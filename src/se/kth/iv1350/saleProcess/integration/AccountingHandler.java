package se.kth.iv1350.saleProcess.integration;

import se.kth.iv1350.saleProcess.model.Sale;
import java.util.LinkedList;

public class AccountingHandler {
    private LinkedList<Sale> accountingList;

    public AccountingHandler() {
        this.accountingList = new LinkedList<>();
    }


    public void sendToAccounting(Sale sale) {
        this.accountingList.add(sale);
    }
}
