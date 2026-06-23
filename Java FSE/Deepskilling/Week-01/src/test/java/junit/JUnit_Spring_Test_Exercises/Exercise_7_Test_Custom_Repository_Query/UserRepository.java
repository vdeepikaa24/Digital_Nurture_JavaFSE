package junit.JUnit_Spring_Test_Exercises.Exercise_7_Test_Custom_Repository_Query;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);
}
