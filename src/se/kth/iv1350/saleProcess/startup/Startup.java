package se.kth.iv1350.saleProcess.startup;

import se.kth.iv1350.saleProcess.controller.Controller;
import se.kth.iv1350.saleProcess.integration.AccountingHandler;
import se.kth.iv1350.saleProcess.integration.Printer;
import se.kth.iv1350.saleProcess.integration.InventoryHandler;
import se.kth.iv1350.saleProcess.integration.ItemRegistry;
import se.kth.iv1350.saleProcess.model.Register;
import se.kth.iv1350.saleProcess.view.View;

/**
 * Startup classin program.
 * Is used to start up the program and create all necessary instances.
 */
public class Startup {

    /**
     * main method in the program that creates instances of the other classes.
     * @param args Command-line arguments. Unused.
     */
    public static void main(String[] args) {
        ItemRegistry itemRegistry = new ItemRegistry();
        Printer printer = new Printer();
        AccountingHandler accountingHandler = new AccountingHandler();
        InventoryHandler inventoryHandler = new InventoryHandler();
        Register register = new Register(printer, itemRegistry, accountingHandler, inventoryHandler);
        Controller contr = new Controller(register);
        View view = new View(contr);

        view.sampleExecutition();
    }
}
