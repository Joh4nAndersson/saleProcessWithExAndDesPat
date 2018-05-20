package se.kth.iv1350.saleProcessWithExceptions.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.saleProcessWithExceptions.integration.AccountingHandler;
import se.kth.iv1350.saleProcessWithExceptions.integration.InventoryHandler;
import se.kth.iv1350.saleProcessWithExceptions.integration.ItemRegistry;
import se.kth.iv1350.saleProcessWithExceptions.integration.Printer;

import static org.junit.Assert.*;

public class RegisterTest {
    private ItemRegistry itemRegistry;
    private Printer printer;
    private AccountingHandler accountingHandler;
    private InventoryHandler inventoryHandler;
    private Register register;
    private Sale sale;

    @Before
    public void setUp() throws Exception {
        itemRegistry = new ItemRegistry();
        printer = new Printer();
        accountingHandler = new AccountingHandler();
        inventoryHandler = new InventoryHandler();
        register = new Register(printer, itemRegistry, accountingHandler, inventoryHandler);
        sale = new Sale(itemRegistry);
        sale.addItem(5, 5);
    }

    @After
    public void tearDown() throws Exception {
        itemRegistry = null;
        printer = null;
        accountingHandler = null;
        inventoryHandler = null;
        register = null;
        sale = null;
    }


    @Test
    public void losAgComplete() {
        register.calculateTotal(sale);
        double expectedResult = 7.5;
        double result = register.losAgComplete(40.0, sale);
        assertEquals(expectedResult, result, 0);
    }

    @Test
    public void calculateTotal() {


        register.calculateTotal(sale);
        double expectedResult = 32.5;
        double result = sale.getTotalWithTaxes();
        assertEquals(expectedResult, result, 0);
    }
}