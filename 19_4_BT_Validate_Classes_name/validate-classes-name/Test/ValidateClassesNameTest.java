import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateClassesNameTest {

    @Test
    void validatePositive1() {
        String classes = "C0223G";
        boolean expect = true;
        boolean result = ValidateClassesName.validate(classes);
        assertEquals(expect, result);
    }

    @Test
    void validatePositive2() {
        String classes = "A0323K";
        boolean expect = true;
        boolean result = ValidateClassesName.validate(classes);
        assertEquals(expect, result);
    }

    @Test
    void validateNegative1() {
        String classes = "M0318G";
        boolean expect = false;
        boolean result = ValidateClassesName.validate(classes);
        assertEquals(expect, result);
    }

    @Test
    void validateNegative2() {
        String classes = "P0323A";
        boolean expect = false;
        boolean result = ValidateClassesName.validate(classes);
        assertEquals(expect, result);
    }
}