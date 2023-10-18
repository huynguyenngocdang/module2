import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateTelephoneNumber {
    private static final String REGEX = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
    public static boolean validate(String telephoneNumber) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(telephoneNumber);
        return matcher.matches();
    }
}
