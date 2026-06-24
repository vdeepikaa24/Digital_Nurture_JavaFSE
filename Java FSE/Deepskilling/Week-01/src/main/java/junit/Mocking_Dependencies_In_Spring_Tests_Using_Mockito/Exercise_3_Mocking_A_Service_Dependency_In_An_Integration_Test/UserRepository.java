package junit.Mocking_Dependencies_In_Spring_Tests_Using_Mockito.Exercise_3_Mocking_A_Service_Dependency_In_An_Integration_Test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
