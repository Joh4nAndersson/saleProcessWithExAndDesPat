package se.kth.iv1350.saleProcess.startup;

import se.kth.iv1350.saleProcess.controller.Controller;
import se.kth.iv1350.saleProcess.integration.AccountingHandler;
import se.kth.iv1350.saleProcess.integration.CustomerRegistry;
import se.kth.iv1350.saleProcess.integration.InventoryHandler;
import se.kth.iv1350.saleProcess.integration.ItemRegistry;
import se.kth.iv1350.saleProcess.model.Register;
import se.kth.iv1350.saleProcess.view.View;

public class Main {
    public static void main(String[] args) {
        ItemRegistry itemRegistry = new ItemRegistry();
        CustomerRegistry customerRegistry = new CustomerRegistry();
        AccountingHandler accountingHandler = new AccountingHandler();
        InventoryHandler inventoryHandler = new InventoryHandler();
        Register register = new Register(customerRegistry, itemRegistry, accountingHandler, inventoryHandler);
        Controller contr = new Controller(register);
        View view = new View(contr);

        view.sampleExecutition();
    }
}
