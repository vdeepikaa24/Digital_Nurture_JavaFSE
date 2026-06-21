package junit.JUnit_Advanced_Testing_Exercises.Exercise_5_Timeout_And_Performance_Testing;

public class PerformanceTester {
    public void performTask() {
        try {
            // Simulate a task that takes 200 milliseconds
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}