package se.kth.iv1350.saleProcess.integration;

import se.kth.iv1350.saleProcess.model.Sale;
import java.util.LinkedList;

public class InventoryHandler {
    private LinkedList<Sale> inventoryList;

    public InventoryHandler() {
        this.inventoryList = new LinkedList<>();
    }

    public void sendToInventory(Sale sale) {
        inventoryList.add(sale);
    }
}
