public class Main {
    public static void main(String[] args) {
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        System.out.println(BinarySearch.binarySearch(list, 2));  /* 0 */
        System.out.println(BinarySearch.binarySearch(list, 11)); /* 4 */
        System.out.println(BinarySearch.binarySearch(list, 79)); /*12 */
        System.out.println(BinarySearch.binarySearch(list, 1));  /*-1 */
        System.out.println(BinarySearch.binarySearch(list, 5));  /*-1 */
        System.out.println(BinarySearch.binarySearch(list, 80)); /*-1 */
    }
}