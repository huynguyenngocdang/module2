import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TriangleTypeTest {
    private int a = 0;
    private int b = 0;
    private  int c = 0;
    private String expected = "";
    private  String result = "";
    @Test
    void getCheckTriangle1() {
        a = 2;
        b = 2;
        c = 2;
        expected = "Equilateral Triangle";
        result = TriangleType.getCheckTriangle(a, b, c);
        assertEquals(expected, result);
    }
    @Test
    void getCheckTriangle2() {
        a = 2;
        b = 2;
        c = 3;
        expected = "Isosceles Triangle";
        result = TriangleType.getCheckTriangle(a, b, c);
        assertEquals(expected, result);
    }
    @Test
    void getCheckTriangle3() {
        a = 3;
        b = 4;
        c = 5;
        expected = "Normal Triangle";
        result = TriangleType.getCheckTriangle(a, b, c);
        assertEquals(expected, result);
    }
    @Test
    void getCheckTriangle4() {
        a = 8;
        b = 2;
        c = 3;
        expected = "Not a Triangle";
        result = TriangleType.getCheckTriangle(a, b, c);
        assertEquals(expected, result);
    }
    @Test
    void getCheckTriangle5() {
        a = -1;
        b = 2;
        c = 1;
        expected = "Not a Triangle";
        result = TriangleType.getCheckTriangle(a, b, c);
        assertEquals(expected, result);
    }
    @Test
    void getCheckTriangle6() {
        a = 0;
        b = 1;
        c = 1;
        expected = "Not a Triangle";
        result = TriangleType.getCheckTriangle(a, b, c);
        assertEquals(expected, result);
    }

}