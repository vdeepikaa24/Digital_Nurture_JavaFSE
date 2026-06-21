package junit.JUnit_Advanced_Testing_Exercises; 

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Exercise_1_Parameterized_Tests {

    private int input;
    private boolean expected;
    // 1. Change this to EvenCheckerForJUnit
    private EvenCheckerForJUnit checker = new EvenCheckerForJUnit();

    public Exercise_1_Parameterized_Tests(int input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { 2, true },
            { 3, false },
            { 4, true },
            { 10, true },
            { 7, false }
        });
    }

    @Test
    public void testIsEven() {
        // 2. The checker.isEven() call will now work because 'checker' is the correct type
        assertEquals("Checking if " + input + " is even", expected, checker.isEven(input));
    }
}