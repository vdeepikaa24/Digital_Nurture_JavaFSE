package junit.JUnit_Spring_Test_Exercises.Exercise_6_Test_Service_Exception_Handling;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
