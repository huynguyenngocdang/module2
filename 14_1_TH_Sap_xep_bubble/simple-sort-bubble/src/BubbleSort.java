import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BubbleSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void main(String[] args) {
        ArrayList<Integer> llList = new ArrayList<>();
        for (int number: list) {
            llList.add(number);
        }
        Collections.sort(llList, (a, b) -> a - b);
        System.out.println(llList.toString());

        bubbleSort(list);
        System.out.print("[");
        for (int number:list ) {
            System.out.print(number + " ");
        }
        System.out.print("]\n");

    }

    public static void bubbleSort(int[] list) {
        boolean needNextPass = true;

        for (int k = 1; k < list.length && needNextPass; k++) {
            /* Array may be sorted and next pass not needed */
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    /* Swap list[i] with list[i + 1] */
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true; /* Next pass still needed */
                }
            }
        }
    }
}
