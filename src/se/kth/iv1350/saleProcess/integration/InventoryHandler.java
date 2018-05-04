package se.kth.iv1350.saleProcess.integration;

import se.kth.iv1350.saleProcess.model.Sale;
import java.util.LinkedList;

/**
 * Class that handles communication with the external inventory system.
 */
public class InventoryHandler {
    private LinkedList<Sale> inventoryList;

    /**
     * Creates a new instance.
     */
    public InventoryHandler() {
        this.inventoryList = new LinkedList<>();
    }

    /**
     * Sends sale information to the external accounting system
     * @param sale Object containing sale information
     */
    public void sendToInventory(Sale sale) {
        inventoryList.add(sale);
    }
}
