public class CheckPalindrome {
    public  boolean isPalindrome (String input) {
        boolean isPalind = true;
        var myStack = new MyStack(input);
        var myQueue = new MyQueue(input);
        char[] chars = input.toCharArray();

        for (char c:chars) {
            myStack.pushCharacter(c);
            myQueue.enqueueCharacter(c);
        }

        for (int i = 0; i < chars.length; i++) {
            if (myStack.popCharacter() != myQueue.dequeueCharacter()) {
                isPalind = false;
                break;
            }
        }

        return isPalind;
    }
}
