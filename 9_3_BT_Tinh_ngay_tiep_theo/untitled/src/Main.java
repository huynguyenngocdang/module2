import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        var scanner = new Scanner(System.in);
        System.out.println("Input new date (dd/MM/yyyy)");
        String currentDate = scanner.next();
        String newDate = NextDayCalculator.nextDate(currentDate);
        System.out.println("New date is: " + newDate);
    }
}