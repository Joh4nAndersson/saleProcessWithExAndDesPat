package se.kth.iv1350.saleProcessWithExAndDesPat.view;

import se.kth.iv1350.saleProcessWithExAndDesPat.controller.Controller;
import se.kth.iv1350.saleProcessWithExAndDesPat.controller.OperationFailedException;
import se.kth.iv1350.saleProcessWithExAndDesPat.integration.ItemDTO;
import se.kth.iv1350.saleProcessWithExAndDesPat.integration.ItemNotFoundException;
import se.kth.iv1350.saleProcessWithExAndDesPat.util.LogHandler;

/**
 * This program has no view, instead, this class is a placeholder for the entire view.
 */
public class View {
  private Controller contr;
  private ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler();
  private LogHandler logger;

    /**
     * Creates a new instance.
     * @param contr The controller that is used for all operations.
     */
  public View (Controller contr) {
    this.contr = contr;
    contr.addRevenueObserver(new TotalRevenueView());
    this.logger = new LogHandler();
  }

    /**
     * Simulates user input that generates calls to all system operations.
     */
  public void sampleExecution() {
      contr.startNewSale();
      System.out.println("Starting new sale");
      System.out.println("");

      try {
          ItemDTO itemDTO = contr.enterItem(11, 2);
          System.out.println("Entering item with ID: 11, quantity: 2");
          System.out.println("Item price: " + itemDTO.getPriceOfItem());
          System.out.println("");
      }
      catch (ItemNotFoundException exc){
          handleException(exc);
      }

      try {
          ItemDTO itemDTO = contr.enterItem(5, 1);
          System.out.println("Entering item with ID: 5, quantity: 1");
          System.out.println("Item price: " + itemDTO.getPriceOfItem());
          System.out.println("");

          System.out.println("Item Description: " + itemDTO.getItemDescription());
          System.out.println("Running total: " + contr.getRunningTotal());
          System.out.println("");

          System.out.println("Finishing Sale");
          double totalWithTaxes = contr.finishSale();
          System.out.println("Total with taxes: " + totalWithTaxes);
          System.out.println("");

          int payment = (int) (totalWithTaxes + 10);
          double change = contr.pay(payment);
          System.out.println("Payment of: " + payment + " resulting in: " + change + " change");
      }
      catch (Exception exc) {
            handleException(exc);
      }

      try {
          ItemDTO itemDTO = contr.enterItem(6, 2);
          System.out.println("Entering item with ID: 5, quantity: 1");
          System.out.println("Item price: " + itemDTO.getPriceOfItem());
          System.out.println("");

          System.out.println("Item Description: " + itemDTO.getItemDescription());
          System.out.println("Running total: " + contr.getRunningTotal());
          System.out.println("");

          System.out.println("Finishing Sale");
          double totalWithTaxes = contr.finishSale();
          System.out.println("Total with taxes: " + totalWithTaxes);
          System.out.println("");

          int payment = (int) (totalWithTaxes + 10);
          double change = contr.pay(payment);
          System.out.println("Payment of: " + payment + " resulting in: " + change + " change");
      }
      catch (Exception exc) {
          handleException(exc);
      }




  }

  private void handleException(Exception exc) {
      errorMsgHandler.showErrorMsg(exc.getMessage());
      logger.logException(exc);
  }

}
