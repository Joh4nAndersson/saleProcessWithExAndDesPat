package se.kth.iv1350.saleProcess.model;

import se.kth.iv1350.saleProcess.integration.AccountingHandler;
import se.kth.iv1350.saleProcess.integration.Printer;
import se.kth.iv1350.saleProcess.integration.InventoryHandler;
import se.kth.iv1350.saleProcess.integration.ItemRegistry;

public class Register {
    private static final double SALES_TAX_FACTOR = 1.3;

    private Printer printer;
    private AccountingHandler accountingHandler;
    private InventoryHandler inventoryHandler;
    private ItemRegistry itemRegistry;

    public Register(Printer printer, ItemRegistry itemRegistry, AccountingHandler accountingHandler, InventoryHandler inventoryHandler) {
        this.printer = printer;
        this.itemRegistry = itemRegistry;
        this.accountingHandler = accountingHandler;
        this.inventoryHandler = inventoryHandler;
    }

    public double losAgComplete(double paidAmount, Sale sale) {
        accountingHandler.sendToAccounting(sale);
        inventoryHandler.sendToInventory(sale);
        double change = calculateChange(paidAmount, sale);
        Receipt receipt = new Receipt(sale, change);
        printer.print(receipt);
        return change;
    }

    public ItemRegistry getItemRegistry() {
        return itemRegistry;
    }

    public void calculateTotal(Sale sale) {
        sale.totalWithTaxes = sale.getRunningTotal() * SALES_TAX_FACTOR;
    }

    private double calculateChange(double paidAmount, Sale sale) {
        return paidAmount - sale.getTotalWithTaxes();
    }
}
