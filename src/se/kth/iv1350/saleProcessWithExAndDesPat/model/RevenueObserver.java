package se.kth.iv1350.saleProcessWithExAndDesPat.model;

import se.kth.iv1350.saleProcessWithExAndDesPat.model.Sale;

public interface RevenueObserver {
    /**
     * Invoked when a sale has been paid
     * @param The sale that was paid for
     */
    void newSale(Sale sale);
}
