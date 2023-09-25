import java.util.Scanner;

public class ConvertTemperature {

    interface Calculate{
        double valueConverted();
    }
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit ");
            choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Input Fahrenheit");
                double fahrenheit = scanner.nextDouble();
//                double celsius = fahrenheitToCelsius(fahrenheit);
//                System.out.println("Celsius: " + celsius);
                Calculate c = () -> ((5.0 / 9) * (fahrenheit - 32));

                System.out.println("Celsius: " + c.valueConverted());
                break;
            case 2:
                System.out.println("Input Celsius");
                double celsius = scanner.nextDouble();
//                fahrenheit = celsiusToFahrenheit(celsius);
//                System.out.println("Fahrenheit: " + fahrenheit);
                Calculate f = () -> ((celsius * 9 / 5) + 32);
                System.out.println("Fahrenheit: " + f.valueConverted());
                break;
            case 0:
                System.out.println("Exiting");
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
        } while (choice != 0);


    }

    public static double celsiusToFahrenheit(double celsius) {
        return ((celsius * 9 / 5) + 32);
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return ((5.0 / 9) * (fahrenheit - 32));
    }
}
