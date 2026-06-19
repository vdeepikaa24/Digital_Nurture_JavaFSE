package engineeringConcepts.designPatternsAndPrinciples.DependencyInjectionExample;

public class CustomerService {
    // Depend on the abstraction (Interface), not the implementation
    private final CustomerRepository repository;

    // STEP 5: Constructor Injection
    // The dependency is supplied ('injected') from the outside world
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void displayCustomerProfile(int id) {
        System.out.println("[Service] Business processing for customer retrieval started...");
        String data = repository.findCustomerById(id);
        System.out.println("[Service] Customer Lookup Result -> " + data);
    }
}