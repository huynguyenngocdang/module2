import java.util.List;

public class RandomListFacade {
    private RandomList randomList;
    private ListFilter listFilter;
    private ListPrinter listPrinter;

    public RandomListFacade() {
        this.randomList = new RandomList();
        this.listFilter = new ListFilter();
        this.listPrinter = new ListPrinter();
    }

    public void printRandomEvenList(int size) {
        // Gọi các phương thức cần thiết và đóng gói logic phức tạp
        List<Integer> randomList = this.randomList.generateList(size);
        List<Integer> filteredList = this.listFilter.filterOdd(randomList);
        this.listPrinter.printList(filteredList);
    }
}
