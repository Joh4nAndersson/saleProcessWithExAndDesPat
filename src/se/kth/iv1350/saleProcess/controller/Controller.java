package se.kth.iv1350.saleProcess.controller;

import se.kth.iv1350.saleProcess.model.Register;
import se.kth.iv1350.saleProcess.model.Sale;

public class Controller {
    private Register register;
    private Sale sale;

    public Controller(Register register) {
        this.register = register;
    }

    public void startNewSale() {
        this.sale = new Sale(register.getItemRegistry());
    }

    public Sale enterItem(int itemID, int quantity) {
        return sale.addItem(itemID, quantity);
    }

    public double finishSale() {
        return register.calculateTotal(sale.getRunningTotal());
    }
}
