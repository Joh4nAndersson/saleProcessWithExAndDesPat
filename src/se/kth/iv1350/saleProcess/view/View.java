package se.kth.iv1350.saleProcess.view;

import se.kth.iv1350.saleProcess.controller.Controller;
import se.kth.iv1350.saleProcess.model.Sale;

public class View {
  private Controller contr;

  public View (Controller contr) {
    this.contr = contr;
  }

  public void sampleExecutition() {
      contr.startNewSale();
      System.out.println("Starting new sale");
      System.out.println("");

      Sale sale = contr.enterItem(8, 2);
      System.out.println("Entering item with ID: 8, quantity: 2");
      System.out.println("Item price: " + sale.getItem().getPriceOfItem());
      System.out.println("");

      System.out.println("Item Description: " + sale.getItem().getItemDescription());
      System.out.println("Running total: " + sale.getRunningTotal());
      System.out.println("");

      //Receipt receipt = contr.finishSale();
      //System.out.println("Total with taxes: " + receipt.getTotalWithTaxes());
      System.out.println("Finishing Sale");
      double totalWithTaxes = contr.finishSale();
      System.out.println("Total with taxes: " + totalWithTaxes);
  }

}
