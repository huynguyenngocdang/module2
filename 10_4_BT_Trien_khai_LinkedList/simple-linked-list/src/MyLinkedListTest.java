public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> llNumbers = new MyLinkedList<>();
        for (int i = 0; i < 11; i++) {
            llNumbers.add(i);
        }
        System.out.println(llNumbers.getFirst());
        System.out.println(llNumbers.getLast());

    }
}
