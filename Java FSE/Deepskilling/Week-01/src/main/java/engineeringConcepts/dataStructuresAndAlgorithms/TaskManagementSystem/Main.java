package engineeringConcepts.dataStructuresAndAlgorithms.TaskManagementSystem;

public class Main {
    public static void main(String[] args) {
        TaskManagement list = new TaskManagement();

        // 1. Appending Tasks
        list.addTask(new Task("T001", "Database Migration", "Pending"));
        list.addTask(new Task("T002", "API Endpoint Documentation", "In Progress"));
        list.addTask(new Task("T003", "Setup CI/CD Pipeline", "Completed"));

        // 2. Traversal
        list.traverseTasks();

        // 3. Searching
        System.out.println("\nSearching for Task T002...");
        Task result = list.searchTask("T002");
        System.out.println("Result: " + (result != null ? result : "Not Found"));

        // 4. Deleting a record from the middle
        System.out.println("\nDeleting Task T002...");
        list.deleteTask("T002");

        // 5. Verification Traversal
        list.traverseTasks();
    }
}