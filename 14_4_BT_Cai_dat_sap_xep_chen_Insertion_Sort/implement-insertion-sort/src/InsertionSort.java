public class InsertionSort {
    static int[] list = {1, 9, 4, 6, 5, -4};
    public static void insertionSort(int[] array){
        int pos, x;
        for(int i = 1; i < array.length; i++){ //đoạn array[0] đã sắp xếp

            x = array[i];
            pos = i;
            while(pos > 0 && x < array[pos-1]){
                array[pos] = array[pos-1]; // đổi chỗ
                pos--;
            }
            array[pos] = x;
        }
    }

    public static void main(String[] args) {
        System.out.println("Array before sort");
        for (int number: list
             ) {
            System.out.print(number + " ");
        }
        System.out.println("\nArray after sort");
        insertionSort(list);
        for (int number: list
        ) {
            System.out.print(number +" ");
        }
    }
}
