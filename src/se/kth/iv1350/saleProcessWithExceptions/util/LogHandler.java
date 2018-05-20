package se.kth.iv1350.saleProcessWithExceptions.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class LogHandler {

    public void logException (Exception exc) {
        System.out.println("LOG ENTRY BEGIN-----------------------------------------------------");
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(createTime());
        logMsgBuilder.append(", Exception was thrown: ");
        logMsgBuilder.append(exc.getMessage());
        System.out.println(logMsgBuilder);
        exc.printStackTrace(System.out);
        System.out.println("LOG ENTRY END-------------------------------------------------------");
    }

    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }

}
