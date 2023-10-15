import java.util.Stack;
public class BracketMatcher {
    public static boolean checkBrackets(String expression) {
        Stack<Character> bStack = new Stack<>();
        for (char sym : expression.toCharArray()) {
            if (sym == '(' || sym == '[' || sym == '{') {
                bStack.push(sym);
            } else if
            (sym == ')' || sym == ']' || sym == '}') {
                if (bStack.isEmpty()) {
                    return false;
                }
                char left = bStack.pop();
                if ((sym == ')' && left != '(') || (sym == ']' && left != '[') || (sym == '}' && left != '{')) {
                    return false;
                }
            }
        }
        return bStack.isEmpty();
    }

    public static void main(String[] args) {
        String expression1 = "s * (s - a) * (s - b) * (s - c)";
        String expression2 = "(-b + (b^2 - 4*a*c)^(0.5/ 2*a))";
        String expression3 = "s * (s - a) * s - b) * (s - c)";
        String expression4 = "s * (s – a) * (s – b * (s – c)";
        System.out.println(checkBrackets(expression1));
        // true
         System.out.println(checkBrackets(expression2));
        // true
         System.out.println(checkBrackets(expression3));
        // false }
        System.out.println(checkBrackets(expression4));
        // }
    }
}
