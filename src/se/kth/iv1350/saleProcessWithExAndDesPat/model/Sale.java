package se.kth.iv1350.saleProcessWithExAndDesPat.model;

import se.kth.iv1350.saleProcessWithExAndDesPat.integration.ItemDTO;
import se.kth.iv1350.saleProcessWithExAndDesPat.integration.ItemNotFoundException;
import se.kth.iv1350.saleProcessWithExAndDesPat.integration.ItemRegistry;
import java.util.LinkedList;

/**
 * Class containing all the information relevant to a sale.
 */
public class Sale {
    private double runningTotal;
    double totalWithTaxes;
    LinkedList<ItemDTO> itemList;
    private ItemRegistry itemRegistry;

    /**
     * Creates a new instance.
     * @param itemRegistry Reference to the item registry.
     */
    public Sale(ItemRegistry itemRegistry) {
        this.runningTotal = 0;
        this.itemList = new LinkedList<>();
        this.itemRegistry = itemRegistry;
    }

    /**
     * Adds item to the current sale.
     * @param itemID Identifier of item to be added.
     * @param quantity Number of said item to be added.
     * @return Sale object containing sale information is returned.
     * @throws ItemNotFoundException Thrown if the itemID is invalid
     */
    public ItemDTO addItem(int itemID, int quantity) throws ItemNotFoundException {
       ItemDTO itemDTO = itemRegistry.itemLookup(itemID, quantity);
       itemList.add(itemDTO);
       runningTotal += itemDTO.getPriceOfItem() * quantity;
       return itemDTO;
    }

    /**
     * Get method for the current running total.
     * @return Running total is returned.
     */
    public double getRunningTotal() {
        return runningTotal;
    }

    /**
     * Get method for the last item added to the sale.
     * @return The last item added to the sale is returned.
     */
    public ItemDTO getItem() {
        return itemList.getLast();
    }

    /**
     * Get method for total with taxes.
     * @return Total with taxes is returned.
     */
    public double getTotalWithTaxes() {
        return totalWithTaxes;
    }

}
