package junit.SL4J_Logging_Exercises.Exercise_2_Parameterized_Logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String name = "Deepikaa";
        int id = 24;

        // Using {} as placeholders
        // SLF4J will replace {} with the provided arguments
        logger.info("User logged in: Name = {}, ID = {}", name, id);

        // You can use multiple placeholders for more complex messages
        try {
            // Intentionally triggers ArithmeticException to demonstrate parameterized logging
            int ignored = 10 / 0;
            logger.debug("Calculation result (should never be logged): {}", ignored);
        } catch (ArithmeticException e) {
            logger.error("Failed to process calculation for ID: {}. Error: {}", id, e.getMessage());
        }

    }
}

