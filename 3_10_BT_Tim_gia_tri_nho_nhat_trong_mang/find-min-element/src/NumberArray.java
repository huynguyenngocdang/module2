import java.util.ArrayList;
import java.util.Scanner;

public class NumberArray {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> numbers = inputArray();
        int min = findSmallestInArray(numbers);
        System.out.println("Array: " + displayArray(numbers));
        System.out.println("Smallest value: " + min + " at index of " + numbers.indexOf(min));

    }

    private static int findSmallestInArray(ArrayList<Integer> numbers) {
        int min = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < min) {
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

        System.out.println("Input array, divide by coma");
        String str = scanner.nextLine();
        str = str.replaceAll(" ", "");
        String[] answer = str.split(",");
        for (String num : answer
        ) {
            numbers.add(Integer.valueOf(num));
        }
        return numbers;
    }


}
