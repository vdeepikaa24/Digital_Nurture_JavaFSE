package junit.SL4J_Logging_Exercises.Exercise_3_Using_Different_Appenders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercise_3_Using_Different_Appenders {
    private static final Logger logger = LoggerFactory.getLogger(Exercise_3_Using_Different_Appenders.class);

    public static void main(String[] args) {
        logger.debug("Debug log: demonstrates the logger level with SLF4J.");
        logger.info("Info log: both console and file appenders should receive this.");
        logger.warn("Warn log: useful for highlighting potential issues.");

        try {
            // Trigger an exception to demonstrate error logging
            int ignored = 10 / 0;
            logger.debug("Unreachable: {}", ignored);
        } catch (ArithmeticException e) {
            logger.error("Error log: exception message = {}", e.getMessage());
        }

        logger.info("Done. Check app.log for file output.");
    }
}

