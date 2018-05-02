package se.kth.iv1350.saleProcess.model;

import se.kth.iv1350.saleProcess.integration.AccountingHandler;
import se.kth.iv1350.saleProcess.integration.CustomerRegistry;
import se.kth.iv1350.saleProcess.integration.InventoryHandler;
import se.kth.iv1350.saleProcess.integration.ItemRegistry;

public class Register {
    private static final double SALES_TAX_FACTOR = 1.3;

    private CustomerRegistry customerRegistry;
    private AccountingHandler accountingHandler;
    private InventoryHandler inventoryHandler;
    private ItemRegistry itemRegistry;

    public Register(CustomerRegistry customerRegistry, ItemRegistry itemRegistry, AccountingHandler accountingHandler, InventoryHandler inventoryHandler) {
        this.customerRegistry = customerRegistry;
        this.itemRegistry = itemRegistry;
        this.accountingHandler = accountingHandler;
        this.inventoryHandler = inventoryHandler;
    }

    public void losAgComplete(Sale sale) {

    }

    public ItemRegistry getItemRegistry() {
        return itemRegistry;
    }

    public double calculateTotal(int totalBeforeTaxes) {
        return totalBeforeTaxes * SALES_TAX_FACTOR;
    }
}
