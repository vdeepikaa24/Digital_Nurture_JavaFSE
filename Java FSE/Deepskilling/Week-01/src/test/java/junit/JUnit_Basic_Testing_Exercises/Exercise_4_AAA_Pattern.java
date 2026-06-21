package junit.JUnit_Basic_Testing_Exercises;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Exercise_4_AAA_Pattern  {

    private int value1;
    private int value2;

    // Setup method runs BEFORE every test method
    @Before
    public void setUp() {
        value1 = 10;
        value2 = 5;
        System.out.println("Setting up: Initializing test values.");
    }

    @Test
    public void testAdditionUsingAAA() {
        // 1. Arrange: Prepare the objects or data needed
        int expected = 15;

        // 2. Act: Call the method being tested
        int actual = value1 + value2;

        // 3. Assert: Verify the result
        assertEquals("The sum of 10 and 5 should be 15", expected, actual);
    }

    // Teardown method runs AFTER every test method
    @After
    public void tearDown() {
        value1 = 0;
        value2 = 0;
        System.out.println("Teardown: Cleaning up test values.");
    }
}