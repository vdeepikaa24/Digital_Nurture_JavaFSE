package junit.JUnit_Spring_Test_Exercises.Exercise_4_Integration_Test_With_SpringBoot;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        if (user == null || user.getName() == null || user.getName().isBlank()) {
            throw new IllegalArgumentException("User name must not be blank");
        }
        return userRepository.save(new User(null, user.getName()));
    }

    public User getUserById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("User id must not be null");
        }
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}

