import java.util.Scanner;

public class ArrayConcat {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Input first array size");
        int sizeArr1 = scanner.nextInt();
        int[] array1 = createArray(sizeArr1, "array1");


        System.out.println("Input second array size");
        int sizeArr2 = scanner.nextInt();
        int[] array2 = createArray(sizeArr2, "array2");
        int[] arrayConcat = concatArray(array1, array2);

        System.out.println("Array 1: " + displayArray(array1));
        System.out.println("Array 2: " + displayArray(array2));
        System.out.println("Array concat: " + displayArray(arrayConcat));
    }

    private static int[] createArray(int size, String name) {
        int[] arr = new int[size];
        int count = 0;
        do {

            for (int i = 0; i < size; i++) {
                System.out.printf("%s, input element %d ", name, (count + 1));
                arr[i] = scanner.nextInt();
                count++;
            }
        } while (count < size);
        return arr;
    }

    private static String displayArray(int[] arr) {
        String displayVal = "";
        for (int i = 0; i < arr.length; i++) {
            displayVal += arr[i] + "\t";
        }
        return displayVal;
    }

    private static int[] concatArray(int[] arr1, int[] arr2) {
        int sizeArr1 = arr1.length;
        int sizeArr2 = arr2.length;
        int sizeConcat = sizeArr1 + sizeArr2;
        int[] arrConcat = new int[sizeConcat];
        for (int i = 0; i < arr1.length; i++) {
            arrConcat[i] = arr1[i];
        }

        for (int j = arr1.length; j < sizeConcat; j++) {
            arrConcat[j] = arr2[j - arr1.length];
        }

        return arrConcat;
    }
}
