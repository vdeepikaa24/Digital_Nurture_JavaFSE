package junit.JUnit_Basic_Testing_Exercises;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Exercise_2_Writing_Basic_JUnit_Tests {

    // Simple method to test directly inside the class
    public int multiply(int a, int b) {
        return a * b;
    }

    @Test
    public void testMultiply() {
        // AAA Pattern: Arrange, Act, Assert
        
        // Arrange
        int a = 5;
        int b = 4;
        
        // Act
        int result = multiply(a, b);
        
        // Assert
        assertEquals("5 * 4 should be 20", 20, result);
    }
}