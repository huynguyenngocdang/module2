import java.time.YearMonth;
import java.util.Scanner;

public class DayOfMonthAdvance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Get day of input month and year");
        System.out.println("Input year: ");
        int year = scanner.nextInt();

        System.out.println("Input month: ");
        int month = scanner.nextInt();

        YearMonth yearMonthObject = YearMonth.of(year, month);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        String result =  daysInMonth + " days";

        System.out.printf("The month '%d' of year '%d' has '%s' ", month, year, result);
    }
}
