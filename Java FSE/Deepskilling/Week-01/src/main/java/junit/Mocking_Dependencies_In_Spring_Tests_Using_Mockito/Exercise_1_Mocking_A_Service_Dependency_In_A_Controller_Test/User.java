package junit.Mocking_Dependencies_In_Spring_Tests_Using_Mockito.Exercise_1_Mocking_A_Service_Dependency_In_A_Controller_Test;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    private String name;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}