import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class BinarySearchTest {
    static int input;
    static int output;
    static int expect;
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
    @Test
    void binarySearch1() {
        input = 2;
        expect = 0;
        output = BinarySearch.binarySearch(list, 2);
        assertEquals(output, expect);
    }
    @Test
    void binarySearch2() {
        input = 2;
        expect = 4;
        output = BinarySearch.binarySearch(list, 11);
        assertEquals(output, expect);
    }
    @Test
    void binarySearch3() {
        input = 2;
        expect = 12;
        output = BinarySearch.binarySearch(list, 79);
        assertEquals(output, expect);
    }
    @Test
    void binarySearch4() {
        input = 2;
        expect = -1;
        output = BinarySearch.binarySearch(list, 1);
        assertEquals(output, expect);
    }
    @Test
    void binarySearch5() {
        input = 2;
        expect = -1;
        output = BinarySearch.binarySearch(list, 5);
        assertEquals(output, expect);
    }
    @Test
    void binarySearch6() {
        input = 2;
        expect = -1;
        output = BinarySearch.binarySearch(list, 80);
        assertEquals(output, expect);
    }
}