import java.util.Scanner;

public class AddElementArray {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Input array size");
        int size = scanner.nextInt();
        int[] numbers = getArray(size);

        String displayOrigin = displayArray(numbers);
        System.out.println("Origin: " + displayOrigin);
        System.out.printf("Add at position(0 - %d): ", numbers.length);
        int indexAdd = scanner.nextInt();
        if (indexAdd <= numbers.length && indexAdd >= 0) {
            System.out.println("Add with: ");
            int valueAdd = scanner.nextInt();
            int[] newNumbers = arrayReplace(numbers, indexAdd, valueAdd);

            String displayNew = displayArray(newNumbers);
            System.out.println("New array: " + displayNew);
        } else {
            System.out.println("Index added is out of range");
        }
    }

    private static int[] getArray(int size) {
        int[] numbers = new int[size];
        int currentIndex = 0;
        do {
            System.out.printf("Input element %d ", (currentIndex+1));
            numbers[currentIndex] = scanner.nextInt();
            currentIndex++;
        } while (currentIndex < size);
        return numbers;
    }

    private static String displayArray (int[] numbers) {
        String display = "";
        for (int number : numbers) {
            display += number + "\t";
        }
        return display;
    }

    private static int[] arrayReplace (int[] numbers, int indexAdd, int valueAdd) {
        int[] newArray = new int[numbers.length + 1];
            for (int i = 0; i < indexAdd; i++) {
                newArray[i] = numbers[i];
            }
            newArray[indexAdd] = valueAdd;
            for (int j = indexAdd + 1; j < numbers.length + 1; j++) {
                newArray[j] = numbers[j - 1];
            }
        return newArray;
    }

}
