package se.kth.iv1350.saleProcessWithExceptions.integration;

/**
 * Class that looks up information on items.
 */
public class ItemRegistry {

    /**
     * Looks up information of item.
     * @param itemID Item to be looked up.
     * @param quantity Quantity of said item.
     * @return Returns Data Transfer Object with item information.
     * @throws ItemNotFoundException Thrown if the itemID is invalid
     */
    public ItemDTO itemLookup(int itemID, int quantity) throws ItemNotFoundException{
        if(validItemID(itemID)) {
            return new ItemDTO(validItemID(itemID),
                    getItemDescription(itemID),
                    getItemPrice(itemID),
                    quantity);
        }
            throw new ItemNotFoundException(itemID);
    }

    private boolean validItemID(int itemID) {
        if(itemID <= 10)
            return true;

        return false;
    }

    private String getItemDescription(int itemID) {
        return "ITEM DESCRIPTION";
    }

    private int getItemPrice(int itemID) {
        return itemID;
    }

}
