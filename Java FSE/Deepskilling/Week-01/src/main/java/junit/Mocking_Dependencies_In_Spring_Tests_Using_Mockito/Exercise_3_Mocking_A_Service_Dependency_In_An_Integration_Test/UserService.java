package junit.Mocking_Dependencies_In_Spring_Tests_Using_Mockito.Exercise_3_Mocking_A_Service_Dependency_In_An_Integration_Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
