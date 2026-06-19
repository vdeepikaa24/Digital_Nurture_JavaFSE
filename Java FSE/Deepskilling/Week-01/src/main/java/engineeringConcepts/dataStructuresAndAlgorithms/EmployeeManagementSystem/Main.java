package engineeringConcepts.dataStructuresAndAlgorithms.EmployeeManagementSystem;

public class Main {
    public static void main(String[] args) {
        
        // Instantiate a manager with an initial static capacity of 5 slots
        EmployeeManager manager = new EmployeeManager(5);

        // 1. Adding Records
        manager.addEmployee(new Employee("E001", "John Doe", "Software Engineer", 85000));
        manager.addEmployee(new Employee("E002", "Jane Smith", "Project Manager", 95000));
        manager.addEmployee(new Employee("E003", "Bob Johnson", "QA Analyst", 70000));
        
        // 2. Traversal
        manager.traverseEmployees();

        // 3. Searching
        System.out.println("\nSearching for employee E002...");
        Employee found = manager.searchEmployee("E002");
        System.out.println("Result: " + (found != null ? found : "Not Found"));

        // 4. Deletion
        System.out.println("\nDeleting employee E002 (Jane Smith)...");
        manager.deleteEmployee("E002");

        // 5. Post-Deletion Traversal (Verifying shift operations)
        manager.traverseEmployees();
    }
}