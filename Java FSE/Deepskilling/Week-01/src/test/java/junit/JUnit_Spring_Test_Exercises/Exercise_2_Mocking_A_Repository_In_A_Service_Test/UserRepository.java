package junit.JUnit_Spring_Test_Exercises.Exercise_2_Mocking_A_Repository_In_A_Service_Test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository provides findById automatically
}
