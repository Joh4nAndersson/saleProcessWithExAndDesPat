package se.kth.iv1350.saleProcessWithExAndDesPat.controller;

import se.kth.iv1350.saleProcessWithExAndDesPat.integration.DatabaseFailureException;
import se.kth.iv1350.saleProcessWithExAndDesPat.integration.ItemDTO;
import se.kth.iv1350.saleProcessWithExAndDesPat.integration.ItemNotFoundException;
import se.kth.iv1350.saleProcessWithExAndDesPat.model.Register;
import se.kth.iv1350.saleProcessWithExAndDesPat.model.RevenueObserver;
import se.kth.iv1350.saleProcessWithExAndDesPat.model.Sale;
import se.kth.iv1350.saleProcessWithExAndDesPat.view.TotalRevenueView;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the applications controller class. All calls to the model class pass through this controller.
 */
public class Controller {
    private Register register;
    private Sale sale;
    //private List<RevenueObserver> revenueObservers = new ArrayList<>();

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
     * @throws ItemNotFoundException Thrown if the itemID is invalid
     */
    public ItemDTO enterItem(int itemID, int quantity) throws ItemNotFoundException {
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

    public double getRunningTotal() {
        return sale.getRunningTotal();
    }

    /**
     * Method that handled the payment of all items.
     * @param paidAmount Amount that has been paid.
     * @return Returns amount of change.
     */
    public double pay(double paidAmount) throws OperationFailedException {
        try {
            return register.losAgComplete(paidAmount, sale);
        }
        catch (DatabaseFailureException exc) {
            throw new OperationFailedException("Operation failed, try again", exc);
        }

    }

    public void addRevenueObserver(TotalRevenueView obs) {
        register.addRevenueObserver(obs);
    }
}
