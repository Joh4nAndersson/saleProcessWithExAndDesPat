package se.kth.iv1350.saleProcessWithExAndDesPat.startup;

import se.kth.iv1350.saleProcessWithExAndDesPat.controller.Controller;
import se.kth.iv1350.saleProcessWithExAndDesPat.integration.AccountingHandler;
import se.kth.iv1350.saleProcessWithExAndDesPat.integration.Printer;
import se.kth.iv1350.saleProcessWithExAndDesPat.integration.InventoryHandler;
import se.kth.iv1350.saleProcessWithExAndDesPat.integration.ItemRegistry;
import se.kth.iv1350.saleProcessWithExAndDesPat.model.Register;
import se.kth.iv1350.saleProcessWithExAndDesPat.view.View;

/**
 * Startup class in program.
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

        view.sampleExecution();
    }
}
