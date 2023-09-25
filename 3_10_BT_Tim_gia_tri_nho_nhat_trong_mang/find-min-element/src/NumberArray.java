import java.util.ArrayList;
import java.util.Scanner;

public class NumberArray {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> numbers = inputArray();
        int min = findSmallestInArray(numbers);
        System.out.println("Array: " + displayArray(numbers));
        System.out.println("Largest value: " + min + " at index of " + numbers.indexOf(min));

    }

    private static int findSmallestInArray(ArrayList<Integer> numbers) {
        int min = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > min) {
                min = numbers.get(i);
            }
        }
        return min;
    }

    private static String displayArray(ArrayList<Integer> numbers) {
        String display = "";
        for (int i = 0; i < numbers.size(); i++) display += numbers.get(i) + "\t";
        return display;
    }

    private static ArrayList<Integer> inputArray() {
        ArrayList<Integer> numbers = new ArrayList<>();
        String answer;
        do {
            System.out.println("Input elements: ");
            numbers.add(scanner.nextInt());
            System.out.println("Continue Y/N: ");
            answer = scanner.next().toUpperCase();
        } while (!answer.equals("N"));
        return numbers;
    }


}
