import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        String type = "";
        var scanner = new Scanner(System.in);
        System.out.println("Input amount: ");
        double amount = scanner.nextDouble();
        System.out.println("Input annual interest: ");
        double interest = scanner.nextDouble();
        System.out.println("Input period (year): ");
        int period = scanner.nextInt();
        do {

        System.out.println("Compound annually or monthly (A/M): ");
        type = scanner.next().toUpperCase();

        } while (!type.equals("A") && !type.equals("M"));
        var helper = new Helper();
        for (int i = 1; i <= period; i++) {
            double compoundAmount = helper.calculateCompoundAmount(amount, interest, i, type);
            double compoundInterest = helper.calculateCompoundInterest(amount, interest, i, type);
            System.out.println( "Year " + i + " : " + helper.formatCurrency(compoundAmount) + " =  " + helper.formatCurrency(amount) + " + "  + helper.formatCurrency(compoundInterest));
        }



    }
}
