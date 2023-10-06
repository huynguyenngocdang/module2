import java.util.*;

//import static java.util.Collections.*;

public class MyStack<T> {

    private Stack<Integer> stack;

    public MyStack() {
        stack = new Stack<>();
    }

    public void reverseStack() {
        Collections.reverse(stack);
    }

    public void push(int i) {
        stack.push(i);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int value : stack
        ) {
            result.append(value).append(",");
        }
        result = new StringBuilder(result.substring(0, result.length() - 1));
        result.append("]");
        return result.toString();
    }
}
