import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NextDayCalculator {
    public static String nextDate (String currentDate) throws ParseException {
        final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        final Date date = format.parse(currentDate);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return format.format(calendar.getTime());
    }
}
