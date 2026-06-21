package junit.JUnit_Basic_Testing_Exercises;

import org.junit.Test;
import static org.junit.Assert.*;

public class Exercise_3_Assertions_in_JUnit{

    @Test
    public void testAssertions() {
        // 1. Assert equals: Checks if two values are the same
        assertEquals("Adding 2 + 3 should equal 5", 5, 2 + 3);

        // 2. Assert true: Checks if a condition is true
        assertTrue("5 should be greater than 3", 5 > 3);

        // 3. Assert false: Checks if a condition is false
        assertFalse("5 should not be less than 3", 5 < 3);

        // 4. Assert null: Checks if an object is null
        String myNullObject = null;
        assertNull("The object should be null", myNullObject);

        // 5. Assert not null: Checks if an object has a value
        assertNotNull("The new Object should not be null", new Object());
    }
}
