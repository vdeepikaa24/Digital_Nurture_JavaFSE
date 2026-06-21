package junit.JUnit_Advanced_Testing_Exercises;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

// Use MethodSorters.NAME_ASCENDING to ensure tests run in a specific order
// by naming them accordingly (e.g., testA, testB, testC).
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Exercise_3_Test_Execution_Order {

    @Test
    public void testA_First() {
        System.out.println("Executing: testA_First");
    }

    @Test
    public void testB_Second() {
        System.out.println("Executing: testB_Second");
    }

    @Test
    public void testC_Third() {
        System.out.println("Executing: testC_Third");
    }
}