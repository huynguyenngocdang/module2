import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        for (int i = 1; i <= 999 ; i++) {
            System.out.println(FizzBuzz.isFizzBuzz(i));
        }
    }
}