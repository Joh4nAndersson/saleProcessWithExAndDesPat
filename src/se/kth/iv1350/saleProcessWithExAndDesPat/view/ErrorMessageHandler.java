package se.kth.iv1350.saleProcessWithExAndDesPat.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * This class shows error messages to the user and prints to the log
 */
class ErrorMessageHandler {


    /**
     * Displays the specified error message.
     *
     * @param msg The error message.
     */
    void showErrorMsg(String msg) {
        StringBuilder errorMsgBuilder = new StringBuilder();
        errorMsgBuilder.append(createTime());
        errorMsgBuilder.append(", ERROR: ");
        errorMsgBuilder.append(msg);
        errorMsgBuilder.append(" (FOR USER) ");
        System.out.println(errorMsgBuilder);
        System.out.println();
    }

    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}
