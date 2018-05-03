package se.kth.iv1350.saleProcess.view;

import se.kth.iv1350.saleProcess.controller.Controller;
import se.kth.iv1350.saleProcess.model.Sale;

/**
 * This program has no view, instead, this class is a placeholder for the entire view.
 */
public class View {
  private Controller contr;

    /**
     * Creates a new instance.
     * @param contr The controller that is used for all operations.
     */
  public View (Controller contr) {
    this.contr = contr;
  }

    /**
     * Simulates user input that generates calls to all system operations.
     */
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

      System.out.println("Finishing Sale");
      double totalWithTaxes = contr.finishSale();
      System.out.println("Total with taxes: " + totalWithTaxes);
      System.out.println("");

      double change = contr.pay(totalWithTaxes + 5);
      System.out.println("Payment of: " + (totalWithTaxes + 5) + " resulting in: " + change + " change");
  }

}
