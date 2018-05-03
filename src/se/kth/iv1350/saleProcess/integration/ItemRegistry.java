package se.kth.iv1350.saleProcess.integration;

public class ItemRegistry {

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
