package junit.JUnit_Spring_Test_Exercises.Exercise_6_Test_Service_Exception_Handling;

public class UserService {

    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }
}
