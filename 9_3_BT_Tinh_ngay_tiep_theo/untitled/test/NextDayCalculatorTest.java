import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class NextDayCalculatorTest {
    private String input = "";
    private String expected = "";
    private String  result = "";
    @Test
    void nextDate1() throws ParseException {
         input = "01/01/2018";
         expected = "02/01/2018";

         result = NextDayCalculator.nextDate(input);
        assertEquals(expected, result);
    }
    @Test
    void nextDate2() throws ParseException {
        input = "31/01/2018";
        expected = "01/02/2018";

        result = NextDayCalculator.nextDate(input);
        assertEquals(expected, result);
    }
    @Test
    void nextDate3() throws ParseException {
        input = "30/04/2018";
        expected = "01/05/2018";

        result = NextDayCalculator.nextDate(input);
        assertEquals(expected, result);
    }
    @Test
    void nextDate4() throws ParseException {
        input = "28/02/2018";
        expected = "01/03/2018";

        result = NextDayCalculator.nextDate(input);
        assertEquals(expected, result);
    }
    @Test
    void nextDate5() throws ParseException {
        input = "29/02/2020";
        expected = "01/03/2020";

        result = NextDayCalculator.nextDate(input);
        assertEquals(expected, result);
    }
    @Test
    void nextDate6() throws ParseException {
        input = "31/12/2018";
        expected = "01/01/2019";

        result = NextDayCalculator.nextDate(input);
        assertEquals(expected, result);
    }
}