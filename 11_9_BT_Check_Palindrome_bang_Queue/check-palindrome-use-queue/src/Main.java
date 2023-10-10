
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Input string");
        String input = scanner.nextLine().toLowerCase();

        input = input.replaceAll(" ", "");
        var checkPalindrome = new CheckPalindrome();
        boolean isPalindrome = checkPalindrome.isPalindrome(input);
        if (isPalindrome) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is NOT palindrome");
        }



    }
}
