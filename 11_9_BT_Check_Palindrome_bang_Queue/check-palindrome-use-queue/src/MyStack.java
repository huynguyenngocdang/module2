import java.util.LinkedList;

public class MyStack {
    private LinkedList<Character> stack = new LinkedList<>();
    private String inputStr;
    public MyStack(String inputStr) {
        this.inputStr = inputStr;
    }
    public void pushCharacter(char currChar) {
                  stack.push(currChar);
        }
    public char popCharacter() {
        return (char) stack.pop();
    }
}
