package se.kth.iv1350.saleProcessWithExAndDesPat.model;

import se.kth.iv1350.saleProcessWithExAndDesPat.integration.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the register.
 */
public class Register {
    private static final double SALES_TAX_FACTOR = 1.3;

    private Printer printer;
    private AccountingHandler accountingHandler;
    private InventoryHandler inventoryHandler;
    private ItemRegistry itemRegistry;
    private List<RevenueObserver> revenueObservers = new ArrayList<>();

    /**
     * Creates a new instance.
     * @param printer Reference to the printer.
     * @param itemRegistry Reference to the item registry.
     * @param accountingHandler Reference to the accouting handler.
     * @param inventoryHandler Reference to the inventory handler.
     */
    public Register(Printer printer, ItemRegistry itemRegistry, AccountingHandler accountingHandler, InventoryHandler inventoryHandler) {
        this.printer = printer;
        this.itemRegistry = itemRegistry;
        this.accountingHandler = accountingHandler;
        this.inventoryHandler = inventoryHandler;
    }

    /**
     * Logs the sale as complete and sends information to the external systems.
     * @param paidAmount The amount paid by the customer.
     * @param sale Object containing sale information.
     * @return The amount of change is returned.
     */
    public double losAgComplete(double paidAmount, Sale sale) throws DatabaseFailureException {
        accountingHandler.sendToAccounting(sale);
        inventoryHandler.sendToInventory(sale);
        double change = calculateChange(paidAmount, sale);
        Receipt receipt = new Receipt(sale, change);
        printer.print(receipt);
        notifyObservers(sale.getTotalWithTaxes());
        return change;
    }

    /**
     * Get method for the item registry.
     * @return The item registry is returned.
     */
    public ItemRegistry getItemRegistry() {
        return itemRegistry;
    }

    /**
     * Calculates the total with taxes.
     * @param sale Object containing sale information.
     */
    public void calculateTotal(Sale sale) {
        sale.totalWithTaxes = sale.getRunningTotal() * SALES_TAX_FACTOR;
    }

    /**
     * Calculates the change that should be given to the customer.
     * @param paidAmount Amount that the customer paid.
     * @param sale Object containing sale information.
     * @return Amount of change is returned.
     */
    private double calculateChange(double paidAmount, Sale sale) {
        return paidAmount - sale.getTotalWithTaxes();
    }

    public void addRevenueObserver(RevenueObserver obs) {
        revenueObservers.add(obs);
    }

    private void notifyObservers(double totalWithTaxes) {
        for (RevenueObserver obs : revenueObservers) {
            obs.newSale(totalWithTaxes);
        }
    }
}
