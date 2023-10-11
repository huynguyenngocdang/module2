import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {
    private String strInput = "";
    private int[] numbers;

    public BinarySearch(String strInput) {
        this.strInput = strInput;
        this.strInput = this.strInput.replaceAll(" ", "");
        String[] strings = this.strInput.split(",");
        this.numbers = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
           this.numbers[i] = Integer.parseInt(strings[i]);
        }
    }

    public void printArray(){
        Arrays.sort(this.numbers);
        System.out.println("Your input array: ");
        for (int number: numbers
             ) {
            System.out.print(number + " ");
        }
    }

    public void printBinarySearch(int value){
        Arrays.sort(this.numbers);
        int low = 0;
        int high = this.numbers.length - 1;
        int resultMid = -1;
        String resultPrint;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (value < numbers[mid]) {
                high = mid - 1;
            } else if (value == numbers[mid]) {
                resultMid = mid;
                break;
            } else  {
                low = low + 1;
            }
        }
        if (resultMid != -1) {
            System.out.printf("Found value %d at index %d", value, resultMid);
        } else {
            System.out.println("Can't find value in array");
        }

    }
}
