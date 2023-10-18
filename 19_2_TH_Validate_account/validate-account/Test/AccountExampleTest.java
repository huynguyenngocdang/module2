import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountExampleTest {
    @Test
    void validateValid1() {
        String account = "123abc_";
        boolean expect = true;
        boolean result = AccountExample.validate(account);
        assertEquals(expect, result);
    }
    @Test
    void validateValid2() {
        String account = "_abc123";
        boolean expect = true;
        boolean result = AccountExample.validate(account);
        assertEquals(expect, result);
    }
    @Test
    void validateValid3() {
        String account = "______";
        boolean expect = true;
        boolean result = AccountExample.validate(account);
        assertEquals(expect, result);
    }
    @Test
    void validateValid4() {
        String account = "123456";
        boolean expect = true;
        boolean result = AccountExample.validate(account);
        assertEquals(expect, result);
    }
    @Test
    void validateValid5() {
        String account = "abcdefg";
        boolean expect = true;
        boolean result = AccountExample.validate(account);
        assertEquals(expect, result);
    }
    @Test
    void validateInvalid1() {
        String account = ".@";
        boolean expect = false;
        boolean result = AccountExample.validate(account);
        assertEquals(expect, result);
    }
    @Test
    void validateInvalid2() {
        String account = "12345";
        boolean expect = false;
        boolean result = AccountExample.validate(account);
        assertEquals(expect, result);
    }
    @Test
    void validateInvalid3() {
        String account = "1234_";
        boolean expect = false;
        boolean result = AccountExample.validate(account);
        assertEquals(expect, result);
    }
    @Test
    void validateInvalid4() {
        String account = "abcde";
        boolean expect = false;
        boolean result = AccountExample.validate(account);
        assertEquals(expect, result);
    }
}