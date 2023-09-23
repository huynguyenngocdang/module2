import java.text.NumberFormat;

public class Helper {
    public double calculateMonthlyPayment(double amount, double interest, int period) {
        double monthlyPayment = 0;
        double monthlyInterest = interest / 12 / 100;
        monthlyPayment = amount * monthlyInterest * Math.pow(1 + monthlyInterest, period) /
                (Math.pow(1 + monthlyInterest, period) - 1);

        return monthlyPayment;
    }

    public double remainingLoanBalance(double amount, double interest, int period, int month) {
        double currentBalance = 0;
        double monthlyInterest = interest / 12 / 100;
        currentBalance = amount * (Math.pow(1 + monthlyInterest, period) - Math.pow(1 + monthlyInterest, month)) /
                (Math.pow(1 + monthlyInterest, period) - 1);
        return currentBalance;
    }

    public String formatCurrency(double amount) {

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String result = formatter.format(amount);
        return result;
    }

    public double calculateCompoundAmount(double amount, double rate, int period, String type) {
        double compoundAmount;
        rate = rate/100;

        int time = 0;
        switch (type) {
            case "A":
                time = 1;
                break;
            case "M":
                    time = 12;
                break;
        }
        compoundAmount = amount * Math.pow (1 + rate/time, time * period);
        return  compoundAmount;
    }

    public double calculateCompoundInterest(double amount, double rate, int period, String type) {
        double compoundInterest;
        rate = rate/100;

        int time = 0;
        switch (type) {
            case "A":
                time = 1;
                break;
            case "M":
                time = 12;
                break;
        }
        compoundInterest = amount * Math.pow (1 + rate/time, time * period) - amount;
        return  compoundInterest;
    }

}
