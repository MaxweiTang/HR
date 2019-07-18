package manage.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date parse(String s) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat();
        return sdf.parse(s);
    }

    public static String reverse(Date date) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        return dateString;
    }
}