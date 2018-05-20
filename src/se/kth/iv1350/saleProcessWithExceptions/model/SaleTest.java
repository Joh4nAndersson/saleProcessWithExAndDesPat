package se.kth.iv1350.saleProcessWithExceptions.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.saleProcessWithExceptions.integration.ItemNotFoundException;
import se.kth.iv1350.saleProcessWithExceptions.integration.ItemRegistry;

import static org.junit.Assert.*;

public class SaleTest {
    ItemRegistry itemRegistry;
    Sale sale;

    @Before
    public void setUp() throws Exception {
        itemRegistry = new ItemRegistry();
        sale = new Sale(itemRegistry);
    }

    @After
    public void tearDown() throws Exception {
        itemRegistry = null;
        sale = null;
    }

    @Test
    public void addItem() throws ItemNotFoundException {
        sale.addItem(1, 1);
        double expectedTotal = 1.0;
        double total = sale.getRunningTotal();
        assertEquals(expectedTotal, total, 0);
    }
}