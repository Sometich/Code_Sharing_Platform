package platform.businesslayer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDataTime {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public static String getTimeNow() {
        return LocalDateTime.now().format(formatter);
    }

}
