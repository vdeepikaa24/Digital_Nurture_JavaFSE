package junit.JUnit_Spring_Test_Exercises.Exercise_8_Test_Controller_Exception_Handling;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
