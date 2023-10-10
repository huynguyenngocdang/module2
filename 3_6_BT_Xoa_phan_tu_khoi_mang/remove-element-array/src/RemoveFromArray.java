import java.util.Scanner;

public class RemoveFromArray {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] numbers = {10, 4, 6, 7, 8, 6};
        String choice;
        do{

        String displayOrigin = displayArray(numbers);
        System.out.println("Origin array: " + displayOrigin);
        System.out.println("Input value to remove");
        int valReplace = scanner.nextInt();

            numbers = removeArray(numbers, valReplace);
        String displayRemoved = displayArray(numbers);
        System.out.println("New array: " + displayRemoved);
            System.out.println("Continue Y/N");
            choice = scanner.next().toUpperCase();
        } while (!choice.equals("N"));


    }

    private static String displayArray (int[] numbers) {
        String display = "";
        for (int i = 0; i < numbers.length; i++) {
            display += numbers[i] + "\t";
        }
        return display;
    }

    private static int[] removeArray (int[] numbers, int valueReplace) {
        int[] newArray = new int[numbers.length- countAppearArray(numbers,valueReplace)];
        for (int i = 0, k =0; i < numbers.length; i++) {
            if (numbers[i] != valueReplace) {
                newArray[k] = numbers[i];
                k++;
            }
        }
        return newArray;
    }

    private static int countAppearArray (int[] numbers, int valueReplace) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == valueReplace) {
                count++;
            }
        }
        return count;
    }
}
