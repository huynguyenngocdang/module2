import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateTelephoneNumberTest {

    @Test
    void validatePositive1() {
        String telephoneNumber = "(84)-(0978489648)";
        boolean expect = true;
        boolean result = ValidateTelephoneNumber.validate(telephoneNumber);
        assertEquals(expect,result);
    }
    @Test
    void validateNegative1() {
        String telephoneNumber = "(a8)-(22222222)";
        boolean expect = false;
        boolean result = ValidateTelephoneNumber.validate(telephoneNumber);
        assertEquals(expect,result);
    }
    @Test
    void validateNegative2() {
        String telephoneNumber = "(84)-(22b22222)";
        boolean expect = false;
        boolean result = ValidateTelephoneNumber.validate(telephoneNumber);
        assertEquals(expect,result);
    }
    @Test
    void validateNegative3() {
        String telephoneNumber = "(84)-(9978489648)";
        boolean expect = false;
        boolean result = ValidateTelephoneNumber.validate(telephoneNumber);
        assertEquals(expect,result);
    }
}