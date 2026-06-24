package junit.Mocking_Dependencies_In_Spring_Tests_Using_Mockito.Exercise_2_Mocking_A_Repository_In_A_Service_Test;

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
