package junit.JUnit_Spring_Test_Exercises.Exercise_9_Parameterized_Test_With_JUnit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserServiceParameterizedTest {

    // Assuming a helper method or validator in your service
    private final EmailValidator validator = new EmailValidator();

    @ParameterizedTest(name = "Test email: {0} should be {1}")
    @CsvSource({
        "john@example.com, true",
        "invalid-email, false",
        "user.name@domain.co, true",
        "@missing-user.com, false"
    })
    public void testEmailValidation(String email, boolean expectedResult) {
        // Act
        boolean actualResult = validator.isValid(email);
        System.out.printf("Email: %s | Expected: %s | Actual: %s%n", email, expectedResult, actualResult);

        // Assert
        if (expectedResult) {
            assertTrue(actualResult, "Email " + email + " should be valid");
        } else {
            assertFalse(actualResult, "Email " + email + " should be invalid");
        }
    }
}
