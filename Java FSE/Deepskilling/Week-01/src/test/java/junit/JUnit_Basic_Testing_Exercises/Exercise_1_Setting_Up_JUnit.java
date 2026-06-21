package junit.JUnit_Basic_Testing_Exercises; // Ensure this matches your folder path

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class Exercise_1_Setting_Up_JUnit {

    @Test
    public void testJUnitIsLoaded() {
        assertTrue("JUnit is working correctly!", true);
    }
}