package se.kth.iv1350.saleProcess.integration;

import se.kth.iv1350.saleProcess.model.Sale;
import java.util.LinkedList;

/**
 * Class that handles communication with the external accounting system.
 */
public class AccountingHandler {
    private LinkedList<Sale> accountingList;

    /**
     * Creates a new instace.
     */
    public AccountingHandler() {
        this.accountingList = new LinkedList<>();
    }

    /**
     * Sends sale information to the external accounting system
     * @param sale Object containing sale information
     */
    public void sendToAccounting(Sale sale) {
        this.accountingList.add(sale);
    }
}
