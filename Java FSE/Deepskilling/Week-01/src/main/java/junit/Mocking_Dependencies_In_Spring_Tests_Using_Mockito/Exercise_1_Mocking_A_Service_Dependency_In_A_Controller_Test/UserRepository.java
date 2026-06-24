package junit.Mocking_Dependencies_In_Spring_Tests_Using_Mockito.Exercise_1_Mocking_A_Service_Dependency_In_A_Controller_Test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // This empty interface allows Spring Data JPA to provide 
    // the findById() method automatically.
}
