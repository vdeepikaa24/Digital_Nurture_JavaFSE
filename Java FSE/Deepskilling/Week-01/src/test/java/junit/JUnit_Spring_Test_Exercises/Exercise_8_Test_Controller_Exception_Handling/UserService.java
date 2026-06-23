package junit.JUnit_Spring_Test_Exercises.Exercise_8_Test_Controller_Exception_Handling;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUserById(Long id) {
        throw new UserNotFoundException("User not found with id: " + id);
    }
}
