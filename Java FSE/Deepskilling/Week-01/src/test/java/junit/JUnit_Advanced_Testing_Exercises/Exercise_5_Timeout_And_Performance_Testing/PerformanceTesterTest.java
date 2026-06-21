package junit.JUnit_Advanced_Testing_Exercises.Exercise_5_Timeout_And_Performance_Testing;

import org.junit.Test;

public class PerformanceTesterTest {

    private PerformanceTester tester = new PerformanceTester();

    // The 'timeout' parameter is in milliseconds
    @Test(timeout = 500)
    public void testPerformTaskTimeout() {
        tester.performTask();
    }

    // This test will fail because it expects completion within 100ms
    @Test(timeout = 300)
    public void testPerformTaskFailure() {
        tester.performTask();
    }
}
