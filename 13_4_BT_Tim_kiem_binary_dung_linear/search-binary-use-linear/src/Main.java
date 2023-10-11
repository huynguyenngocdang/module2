import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Input array of integer, divide by coma");
        BinarySearch binarySearch = new BinarySearch(scanner.nextLine());
        binarySearch.printArray();
        System.out.println("Input value to search");
        binarySearch.printBinarySearch(scanner.nextInt());
    }
}