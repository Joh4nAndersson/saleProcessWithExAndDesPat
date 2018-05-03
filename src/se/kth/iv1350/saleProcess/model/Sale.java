package se.kth.iv1350.saleProcess.model;

import se.kth.iv1350.saleProcess.integration.ItemDTO;
import se.kth.iv1350.saleProcess.integration.ItemRegistry;
import java.util.LinkedList;

public class Sale {
    private double runningTotal;
    double totalWithTaxes;
    LinkedList<ItemDTO> itemList;
    private ItemRegistry itemRegistry;

    public Sale(ItemRegistry itemRegistry) {
        this.runningTotal = 0;
        this.itemList = new LinkedList<>();
        this.itemRegistry = itemRegistry;
    }

    public Sale addItem(int itemID, int quantity) {
       ItemDTO itemDTO = itemRegistry.itemLookup(itemID, quantity);
       itemList.add(itemDTO);
       runningTotal += itemDTO.getPriceOfItem() * quantity;
       return this;
    }

    public double getRunningTotal() {
        return runningTotal;
    }

    public ItemDTO getItem() {
        return itemList.getLast();
    }

    public double getTotalWithTaxes() {
        return totalWithTaxes;
    }

}
