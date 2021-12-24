package com.msb.supports.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private DateUtil() {
    }
    public static final String  RFC3339_DATE_FORMAT        = "yyyy-MM-dd'T'HH:mm:ssXXX";

    public static String convertToRFC3339(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(RFC3339_DATE_FORMAT);
        return format.format(date);
    }
}
