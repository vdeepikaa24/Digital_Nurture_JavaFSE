package junit.Mocking_Dependencies_In_Spring_Tests_Using_Mockito.Exercise_3_Mocking_A_Service_Dependency_In_An_Integration_Test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Test-only Spring Boot application that limits component scanning to Exercise 3.
 * This avoids bean-name collisions with other exercises that may define beans like "userService".
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = UserController.class)
public class Exercise3TestApplication {
}


