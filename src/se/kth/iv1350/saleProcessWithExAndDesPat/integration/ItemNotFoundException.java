package se.kth.iv1350.saleProcessWithExAndDesPat.integration;


/**
 * Thrown when trying to add an item with an invalid identifier
 */
public class ItemNotFoundException extends Exception {

    private int itemThatCanNotBeFound;

    /**
     * Creates a new instance with a message specifying which item could not be found
     *
     * @param msg The item that could not be found
     */
    public ItemNotFoundException(int itemThatCanNotBeFound) {
        super("Unable to find item " + itemThatCanNotBeFound + " in Item Registry");
        this.itemThatCanNotBeFound = itemThatCanNotBeFound;
    }

    /**
     *
     * @return The item that could not be found in the registry
     */
    public int getItemThatCanNotBeFound() {
        return this.itemThatCanNotBeFound;
    }
}
