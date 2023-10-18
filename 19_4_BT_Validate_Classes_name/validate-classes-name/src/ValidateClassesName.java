import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClassesName {
    private static final String REGEX = "^[CAP]\\d{4}[GHIK]";
    public static boolean validate(String classesName) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(classesName);
        return matcher.matches();
    }
}
