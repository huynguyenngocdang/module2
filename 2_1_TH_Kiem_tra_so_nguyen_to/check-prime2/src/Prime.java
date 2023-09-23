import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        try {
            String continueInput = "Y";
            var scanner = new Scanner(System.in);
            while (!continueInput.equals("N")) {


                System.out.println("Enter a number: ");

                int numberInput = scanner.nextInt();
                var helper = new Helper();
                boolean result = helper.isPrime(numberInput);
                if (result) {
                    System.out.printf("%d is a prime number", numberInput);
                } else {
                    System.out.printf("%d is NOT a prime number", numberInput);
                }
                System.out.print("\nContinue Y/N: ");
                continueInput = scanner.next().toUpperCase();
            }
            ;

        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}

class Helper {
    public boolean isPrime(int a) {
        boolean result;
        if (a < 2) {
            return false;

        } else {
            int i = 2;
            result = true;
            while (i <= Math.sqrt(a)) {
                if (a % i == 0) {
                    result = false;
                    break;
                }
                i++;
            }
        }
        return result;
    }


}
