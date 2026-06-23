package junit.JUnit_Spring_Test_Exercises.Exercise_5_Test_Controller_POST_Endpoint;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User saveUser(User user) {
        return user;
    }
}
