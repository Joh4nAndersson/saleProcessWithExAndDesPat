package se.kth.iv1350.saleProcess.model;

import se.kth.iv1350.saleProcess.integration.ItemDTO;
import java.util.LinkedList;

public class Receipt {
    //public static final double SALES_TAX_FACTOR = 1.3;

   //double totalWithTaxes;
    double change;
    LinkedList<ItemDTO> itemList;

    public Receipt(Sale sale){
        this.itemList = sale.itemList;
        //this.totalWithTaxes =
        //this.totalWithTaxes = additionOfTaxes(sale.total);
        // TODO: add change
    }

   /* public double getTotalWithTaxes() {
        return totalWithTaxes;
    }

    private double additionOfTaxes(int total){
        return total * SALES_TAX_FACTOR;
    } */
}
