import java.util.Scanner;

public class WordCount {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Input words");
        String inputString = scanner.nextLine();

        System.out.println("Input count characters");
        char character = scanner.next().toLowerCase().charAt(0);

        int count = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (character == inputString.toLowerCase().charAt(i)  ) {
                count++;
            }
        }
        System.out.printf("\n '%s' appear %d times in words '%s' ", character, count, inputString);
    }
}
