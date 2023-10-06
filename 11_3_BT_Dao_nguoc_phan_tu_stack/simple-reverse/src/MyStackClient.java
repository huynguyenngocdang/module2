import java.util.Scanner;

public class MyStackClient {
    private static Scanner scanner = new Scanner(System.in);
    private static MyStack myStack = new MyStack();

    public static void main(String[] args) {
        String confirm;
        do {
            System.out.println("Input number");
            myStack.push(scanner.nextInt());
            System.out.println("Continue Y/N");
            confirm = scanner.next().toUpperCase();
        } while (!confirm.equals("N"));
        System.out.println("Your stack is: " + myStack.toString());
        myStack.reverseStack();
        System.out.println("Your reverse stack is: " + myStack.toString());
    }
}
