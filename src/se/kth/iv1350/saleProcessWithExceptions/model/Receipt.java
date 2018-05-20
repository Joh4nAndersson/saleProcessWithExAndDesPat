package se.kth.iv1350.saleProcessWithExceptions.model;

import se.kth.iv1350.saleProcessWithExceptions.integration.ItemDTO;
import java.util.LinkedList;

/**
 * Class that represents a receipt.
 */
public class Receipt {
    private double totalWithTaxes;
    private double change;
    private LinkedList<ItemDTO> itemList;

    /**
     * Creates a new instance.
     * @param sale Object containing sale information.
     * @param change Amount of change to be given to customer.
     */
    public Receipt(Sale sale, double change){
        this.itemList = sale.itemList;
        this.totalWithTaxes = sale.totalWithTaxes;
        this.change = change;
    }
}
