import java.util.LinkedList;

public class MyQueue {
  private LinkedList<Character> queue = new LinkedList<>();
  private String inputStr;
    public MyQueue(String inputStr) {
        this.inputStr = inputStr;
    }
    public void enqueueCharacter(char currChar) {
            queue.addLast(currChar);
    }
    public char dequeueCharacter() {
        return (char) queue.remove(0);
    }
}
