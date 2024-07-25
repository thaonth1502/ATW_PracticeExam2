package Common;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CommonClass {

    public static String URL = "https://www.demo.guru99.com/";
    public static String EMAIL = "huongthao89@gmail.com";
    public static String NAVIGATE_URL = "https://www.demo.guru99.com/v4/";

    public static String convertFormatStringToDate (String currertString) throws ParseException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
//        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
//        dateConvert = date.format(dateFormat.parse(dateConvert));
//        return dateConvert;
        String dataConvert = currertString;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        dataConvert = date.format(dateFormat.parse(dataConvert));
        return dataConvert;
    }
}
