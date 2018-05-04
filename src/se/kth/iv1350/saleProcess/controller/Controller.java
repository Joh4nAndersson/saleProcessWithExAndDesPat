package se.kth.iv1350.saleProcess.controller;

import se.kth.iv1350.saleProcess.model.Register;
import se.kth.iv1350.saleProcess.model.Sale;

/**
 * This is the applications controller class. All calls to the model class pass through this controller.
 */
public class Controller {
    private Register register;
    private Sale sale;

    /**
     * Creates a new instance.
     * @param register Interface to register.
     */
    public Controller(Register register) {
        this.register = register;
    }

    /**
     * Starts a new sale.
     */
    public void startNewSale() {
        this.sale = new Sale(register.getItemRegistry());
    }

    /**
     * Enters item into sale
     * @param itemID Item to be entered.
     * @param quantity Number of said item to be entered.
     * @return Returns object containing sale information.
     */
    public Sale enterItem(int itemID, int quantity) {
        return sale.addItem(itemID, quantity);
    }

    /**
     * When all items are entered this method is called to finish the sale
     * and calculate the total with taxes.
     * @return Returns total with taxes added.
     */
    public double finishSale() {
        register.calculateTotal(sale);
        return sale.getTotalWithTaxes();
    }

    /**
     * Method that handled the payment of all items.
     * @param paidAmount Amount that has been paid.
     * @return Returns amount of change.
     */
    public double pay(double paidAmount) {
        return register.losAgComplete(paidAmount, sale);
    }
}
