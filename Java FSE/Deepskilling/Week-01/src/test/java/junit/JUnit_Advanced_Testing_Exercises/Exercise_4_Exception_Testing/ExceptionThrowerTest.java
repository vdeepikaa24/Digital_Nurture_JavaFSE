package junit.JUnit_Advanced_Testing_Exercises.Exercise_4_Exception_Testing;

import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals; 

public class ExceptionThrowerTest {

    private ExceptionThrower thrower = new ExceptionThrower();

    @Test(expected = IllegalArgumentException.class)
    public void testThrowException_Simple() {
        thrower.throwException();
    }

    @Test
    public void testThrowException_Detailed() {
        try {
            thrower.throwException();
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid argument provided!", e.getMessage());
        }
    }
}