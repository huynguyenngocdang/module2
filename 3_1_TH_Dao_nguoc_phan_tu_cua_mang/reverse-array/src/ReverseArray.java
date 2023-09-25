import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {

        static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int size = arraySize();
        int[] array = arrayInput(size);
        String arrayOriginDisplay = arrayDisplay(array);
        System.out.println("Origin: " + arrayOriginDisplay);
        array = arrayReverse(array);
        String arrayReverseDisplay = arrayDisplay(array);
        System.out.println("Reverse: " + arrayReverseDisplay);
    }
    private static int arraySize () {
        int size;

        do {
            System.out.println("Enter a size");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.println("Size should not exceed 20");
            }
        }while (size > 20);
        return size;
    }
    private static int[] arrayInput (int size) {
        var array = new int[size];

        int i = 0;
        while (i < size) {
            System.out.println("Enter an element " + (i+1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        return array;
    }

    private static String arrayDisplay(int[] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += array[i] + "\t";
        }
        return  result;
    }

    private static int[] arrayReverse (int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}
