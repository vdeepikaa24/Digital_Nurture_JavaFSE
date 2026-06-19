package engineeringConcepts.designPatternsAndPrinciples.DependencyInjectionExample;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. Initializing Dependencies ===");
        // Instantiate the concrete engine (Infrastructure layer)
        CustomerRepository productionDatabase = new CustomerRepositoryImpl();

        System.out.println("\n=== 2. Injecting Repository into Service ===");
        // Pass the database implementation cleanly into the service instance
        CustomerService customerService = new CustomerService(productionDatabase);

        System.out.println("\n=== 3. Running Core Application Logic ===");
        // Test existing IDs
        customerService.displayCustomerProfile(101);
        System.out.println();
        customerService.displayCustomerProfile(105);
    }
}