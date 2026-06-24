package junit.Mocking_Dependencies_In_Spring_Tests_Using_Mockito.Exercise_2_Mocking_A_Repository_In_A_Service_Test;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    private String name;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
