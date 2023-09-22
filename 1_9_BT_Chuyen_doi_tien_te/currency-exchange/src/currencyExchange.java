import java.text.NumberFormat;
import java.util.Scanner;

public class currencyExchange {
    static final double rateVND = 23_000;
    static final double rateUSD = 1;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input from currency (USD/VND): ");
        String fromCurr = scanner.next();
        System.out.println("Input from amount: ");
        double fromAmount = scanner.nextDouble();
        double toAmount = 0;
        String toCurr;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String toString;
        switch (fromCurr) {
            case "VND":
                toAmount = fromAmount/ rateVND;
                toCurr = "USD";
                toString = formatter.format(toAmount);
                System.out.printf("%s %s", toString, toCurr);
                break;
            case "USD":
                toAmount = fromAmount * rateVND;
                toCurr = "VND";
                toString = formatter.format(toAmount);
                System.out.printf("%s %s", toString, toCurr);
                break;
            default:
                System.out.println("Invalid input");
        }


    }


}
