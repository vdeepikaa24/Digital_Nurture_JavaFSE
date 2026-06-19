package engineeringConcepts.designPatternsAndPrinciples.DependencyInjectionExample;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // Simulating a real database fetch sequence
        if (id == 101) {
            return "John Doe (Premium Tier)";
        } else if (id == 102) {
            return "Jane Smith (Standard Tier)";
        } else {
            return "Customer Record Not Found";
        }
    }
}