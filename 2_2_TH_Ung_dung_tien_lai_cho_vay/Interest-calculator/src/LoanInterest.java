import java.text.NumberFormat;
import java.util.Scanner;

public class LoanInterest {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Input amount: ");
        double amount = scanner.nextDouble();
        System.out.println("Input annual interest: ");
        double interest = scanner.nextDouble();
        System.out.println("Input period (month): ");
        int period = scanner.nextInt();
        var helper = new Helper();

        double monthlyPayment = helper.calculateMonthlyPayment(amount, interest, period);


        String result = helper.formatCurrency(monthlyPayment);
        System.out.printf("Monthly payment is %s \n", result);
        System.out.println("LOAN SCHEDULE");
        System.out.println("--------");
        for (int i = 1; i <= period; i++) {
            double remainingBalance = helper.remainingLoanBalance(amount, interest, period, i);
            String remainingFormat = helper.formatCurrency(remainingBalance);
            System.out.println("Month " + i + ": " + remainingFormat);
        }
    }
}

