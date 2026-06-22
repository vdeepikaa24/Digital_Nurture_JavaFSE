package junit.JUnit_Spring_Test_Exercises.Exercise_3_Testing_A_Rest_Controller_With_MockMvc;


import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUserById(Long id) {
        // In real app: fetch from repository/db.
        // For testing, this method will be mocked.
        return null;
    }
}

