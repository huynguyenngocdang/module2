public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> llNumbers = new MyLinkedList<>();
        for (int i = 0; i < 11; i++) {
            llNumbers.add(i);
        }
        System.out.println("Numbers contain");
        System.out.println(llNumbers.getFirst());
        System.out.println(llNumbers.getLast());
        MyLinkedList<String> llStrings = new MyLinkedList<>();
        for (int i = 0; i < 11; i++) {
            llStrings.add(String.valueOf(i));
        }
        System.out.println("String contains");
        System.out.println(llStrings.getFirst());
        System.out.println(llStrings.getLast());
        System.out.println(llStrings.get(5));

    }
}
