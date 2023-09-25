import java.util.Scanner;

public class ConvertTemperature {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit ");
            choice = scanner.nextInt();
        } while (choice != 0);
        switch (choice) {
            case 1:
                System.out.println("Input Fahrenheit");
                double fahrenheit = scanner.nextDouble();
                double celsius = fahrenheitToCelsius(fahrenheit);
                System.out.println("Celsius: " + celsius);
                break;
            case 2:
                System.out.println("Input Celsius");
                celsius = scanner.nextDouble();
                fahrenheit = celsiusToFahrenheit(celsius);

                System.out.println("Fahrenheit: " + fahrenheit);
                break;

            default:
                System.out.println("Invalid input");
                break;
        }


    }

    public static double celsiusToFahrenheit(double celsius) {
        return ((celsius * 9 / 5) + 32);
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return ((5.0 / 9) * (fahrenheit - 32));
    }
}
