import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexExample {

    public static void main(String[] args) {
        // The input string
        String input = "Hello java regex 2-12-2018, hello world 12/12/2018";

        // The regular expression
        String regex = "\\d{1,2}[-/]\\d{1,2}[-/]\\d{4}";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(input);

        // Find and print the matches
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}