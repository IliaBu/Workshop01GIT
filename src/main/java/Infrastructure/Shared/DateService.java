package Infrastructure.Shared;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateService {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
    public static String dateToString(Date date){
        return  formatter.format(date);
    }

    public static Date stringToDate(String string){
        try {
            return formatter.parse(string);
        } catch (ParseException ignored) {
            throw  new IllegalArgumentException();
        }
    }
}
