import java.util.Scanner;

public class WordCountTest {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Input string");
        var wordCount = new WordCount(scanner.nextLine());
        wordCount.countWord();
    }
}
