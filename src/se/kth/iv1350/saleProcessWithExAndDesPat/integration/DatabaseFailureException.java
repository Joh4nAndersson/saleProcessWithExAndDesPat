package se.kth.iv1350.saleProcessWithExAndDesPat.integration;

public class DatabaseFailureException extends RuntimeException {

    public DatabaseFailureException(String msg) {
        super(msg);
    }
}
