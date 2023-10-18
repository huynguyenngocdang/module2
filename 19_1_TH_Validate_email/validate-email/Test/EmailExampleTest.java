import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class EmailExampleTest {
private EmailExample emailExample = new EmailExample();
    @Test
    void validate1() {
        String email = "a@gmail.com";
        boolean expect = true;
        boolean result = emailExample.validate(email);
        assertEquals(expect, result);
    }
    @Test
    void validate2() {
        String email = "@gmail.com";
        boolean expect = false;
        boolean result = emailExample.validate(email);
        assertEquals(expect, result);
    }
}