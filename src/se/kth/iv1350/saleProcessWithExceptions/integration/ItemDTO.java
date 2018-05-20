package se.kth.iv1350.saleProcessWithExceptions.integration;

/**
 * Data Transfer Object for the Items.
 */
public class ItemDTO {
    private final boolean validItem;
    private final String itemDescription;
    private final int priceOfItem;
    private final int quantity;

    /**
     * Creates a new instance.
     * @param validItem True if valid item.
     * @param itemDescription Description of item.
     * @param priceOfItem The items price.
     * @param quantity Quantity of the item.
     */
    public ItemDTO(boolean validItem, String itemDescription, int priceOfItem, int quantity) {
        this.validItem = validItem;
        this.itemDescription = itemDescription;
        this.priceOfItem = priceOfItem;
        this.quantity = quantity;
    }

    /**
     * Get method for the price.
     * @return The price of the item is returned
     */
    public int getPriceOfItem() {
        return priceOfItem;
    }

    /**
     * Get method for the item description
     * @return The item description is returned
     */
    public String getItemDescription() {
        return itemDescription;
    }
}
