import java.util.Scanner;

public class Main {
static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Input a string");
        Helper helper = new Helper(scanner.nextLine());
        helper.convertToASCII();
//        helper.printNumbersConvert();
//        helper.printTotal();
//        helper.printSortNumbers();
        helper.printResult();
    }
}