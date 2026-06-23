package junit.JUnit_Spring_Test_Exercises.Exercise_6_Test_Service_Exception_Handling;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long id);
}
