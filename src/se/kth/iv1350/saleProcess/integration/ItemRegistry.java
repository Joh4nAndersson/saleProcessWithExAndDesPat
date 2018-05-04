package se.kth.iv1350.saleProcess.integration;

/**
 * Class that looks up information on items.
 */
public class ItemRegistry {

    /**
     * Looks up information of item.
     * @param itemID Item to be looked up.
     * @param quantity Quantity of said item.
     * @return Returns Data Transfer Object with item information.
     */
    public ItemDTO itemLookup(int itemID, int quantity) {

        return new ItemDTO(validItemID(itemID),
                                        getItemDescription(itemID),
                                        getItemPrice(itemID),
                                        quantity);
    }

    private boolean validItemID(int itemID) {
        return true;
    }

    private String getItemDescription(int itemID) {
        return "ITEM DESCRIPTION";
    }

    private int getItemPrice(int itemID) {
        return itemID;
    }

}
