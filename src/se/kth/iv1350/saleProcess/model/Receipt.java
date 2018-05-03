package se.kth.iv1350.saleProcess.model;

import se.kth.iv1350.saleProcess.integration.ItemDTO;
import java.util.LinkedList;

public class Receipt {
    private double totalWithTaxes;
    private double change;
    private LinkedList<ItemDTO> itemList;

    public Receipt(Sale sale, double change){
        this.itemList = sale.itemList;
        this.totalWithTaxes = sale.totalWithTaxes;
        this.change = change;
    }
}
