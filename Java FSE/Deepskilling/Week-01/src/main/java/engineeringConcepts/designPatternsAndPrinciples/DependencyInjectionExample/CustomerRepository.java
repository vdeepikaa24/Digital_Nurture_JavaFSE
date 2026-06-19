package engineeringConcepts.designPatternsAndPrinciples.DependencyInjectionExample;

public interface CustomerRepository {
    String findCustomerById(int id);
}