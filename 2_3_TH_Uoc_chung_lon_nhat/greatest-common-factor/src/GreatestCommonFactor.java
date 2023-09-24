import java.util.Scanner;

public class GreatestCommonFactor {
    public static void main(String[] args) {
        try {
            var scanner = new Scanner(System.in);
            System.out.println("Input a: ");
            int a = scanner.nextInt();
            System.out.println("Input b: ");
            int b = scanner.nextInt();

        var helper = new Helper();

        if (helper.isZero(a) || helper.isZero(b)) {
            System.out.println("No greatest common factor");
        } else {
            int result = helper.largestCommonFactor(a, b);
            System.out.printf("Greatest common factor of %d and %d is %d", a, b, result);
        }
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}
