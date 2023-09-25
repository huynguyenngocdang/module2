import java.util.ArrayList;
import java.util.Scanner;

public class NumberArray {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        String quit = "Y";
        do {
            System.out.println("Input element");
            numbers.add(scanner.nextInt());
            System.out.println("Quit? Y/N:");
            quit = scanner.next().toUpperCase();
        } while (!quit.equals("Y"));
        System.out.print("Origin array: \n");
        for (int i = 0; i < numbers.size(); i++){
            System.out.print(numbers.get(i) + "\t");
        }
        int max = getMax(numbers);
        System.out.printf("\n Largest value is %d at position %d", max, numbers.indexOf(max) + 1);
    }

    private static int getMax(ArrayList<Integer> numbers) {
        int maxInt = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > maxInt) {
                maxInt = numbers.get(i);
            }
        }
        return maxInt;
    }
}
