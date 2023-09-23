import java.util.Scanner;

public class numberToWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number (0-999): ");
        int numInput = scanner.nextInt();
        int numConvert = numInput;
        String word;
        String[] numNames = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        String[] tenNames = {"",
                "ten ",
                "twenty ",
                "thirty ",
                "forty ",
                "fifty ",
                "sixty ",
                "seventy ",
                "eighty ",
                "ninety "};

        if (numConvert % 100 < 20) {
            word = numNames[numConvert % 100];
            numConvert /= 100;
        } else {
            word = numNames[numConvert % 10];
            numConvert /= 10;

            word = tenNames[numConvert % 10] + word;
            numConvert /= 10;
        }
        if (numConvert == 0) {
            System.out.printf("%d is %s", numInput, word);
        } else {

            System.out.printf("%d is %s hundred %s", numInput, numNames[numConvert], word);
        }

    }
}
