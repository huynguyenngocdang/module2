import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class FizzBuzzTest {
    private final String fizz = "Fizz";
    private final String buzz = "Buzz";
    private final String fizzBuzz = "FizzBuzz";
    private String expectedStr = "";
    private String result = "";

    @Test
    void isFizzBuzz1() {
        expectedStr = "mot";
        result =FizzBuzz.isFizzBuzz(1);
        assertEquals(result, expectedStr);
    }

    @Test
    void isFizzBuzz2() {
        expectedStr = "hai";
        result =FizzBuzz.isFizzBuzz(2);
        assertEquals(result, expectedStr);
    }

    @Test
    void isFizzBuzz3() {
        expectedStr = fizz;
        result =FizzBuzz.isFizzBuzz(3);
        assertEquals(result, expectedStr);
    }
    @Test
    void isFizzBuzz4() {
        expectedStr = "bon";
        result =FizzBuzz.isFizzBuzz(4);
        assertEquals(result, expectedStr);
    }

    @Test
    void isFizzBuzz5() {
        expectedStr = buzz;
        result =FizzBuzz.isFizzBuzz(5);
        assertEquals(result, expectedStr);
    }

    @Test
    void isFizzBuzz15() {
        expectedStr = fizzBuzz;
        result =FizzBuzz.isFizzBuzz(15);
        assertEquals(result, expectedStr);
    }
}