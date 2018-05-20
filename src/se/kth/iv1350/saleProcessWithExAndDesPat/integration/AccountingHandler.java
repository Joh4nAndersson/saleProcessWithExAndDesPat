package se.kth.iv1350.saleProcessWithExAndDesPat.integration;

import se.kth.iv1350.saleProcessWithExAndDesPat.model.Sale;
import java.util.LinkedList;

/**
 * Class that handles communication with the external accounting system.
 */
public class AccountingHandler {
    private LinkedList<Sale> accountingList;

    /**
     * Creates a new instance.
     */
    public AccountingHandler() {
        this.accountingList = new LinkedList<>();
    }

    /**
     * Sends sale information to the external accounting system
     * @param sale Object containing sale information
     */
    public void sendToAccounting(Sale sale) throws DatabaseFailureException {
        if(sale.getItem().getPriceOfItem() == 5)
            throw new DatabaseFailureException("ERROR, Database failure, Accounting system");

        this.accountingList.add(sale);
    }
}
