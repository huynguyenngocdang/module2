import java.util.Scanner;

public class LeapYearCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Input year: ");
            int year = scanner.nextInt();
            boolean isLeapYear = false;
            String result;
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        isLeapYear = true;
                    } 
                } else {
                    isLeapYear = true;
                }
            }
            if (isLeapYear) {
                System.out.printf("%d is a leap year", year);
            } else {
                System.out.printf("%d is NOT a leap year", year);
            }
        }
    }
}

