package se.kth.iv1350.saleProcessWithExceptions.integration;

public class DatabaseFailureException extends RuntimeException {

    public DatabaseFailureException(String msg) {
        super(msg);
    }
}
