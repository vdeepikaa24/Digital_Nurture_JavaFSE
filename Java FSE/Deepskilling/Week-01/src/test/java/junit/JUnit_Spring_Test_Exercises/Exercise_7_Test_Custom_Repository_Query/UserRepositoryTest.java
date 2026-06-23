package junit.JUnit_Spring_Test_Exercises.Exercise_7_Test_Custom_Repository_Query;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        // Arrange: Use TestEntityManager to persist a user to the H2 database
        User user = new User();
        user.setName("John Doe");
        entityManager.persist(user);
        entityManager.flush(); // Ensure data is written to the DB

        // Act: Call the custom repository method
        List<User> foundUsers = userRepository.findByName("John Doe");

        // Assert: Verify the result
        assertEquals(1, foundUsers.size());
        assertEquals("John Doe", foundUsers.get(0).getName());
    }
}
