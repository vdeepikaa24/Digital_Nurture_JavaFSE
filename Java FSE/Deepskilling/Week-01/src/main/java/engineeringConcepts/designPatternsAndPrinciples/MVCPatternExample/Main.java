package engineeringConcepts.designPatternsAndPrinciples.MVCPatternExample;

public class Main {
    public static void main(String[] args) {
        // 1. Fetch/Simulate record from database (Model initialization)
        Student studentRecord = fetchStudentFromDatabase();

        // 2. Setup the presentation platform (View initialization)
        StudentView view = new StudentView();

        // 3. Link them up using the Controller
        StudentController controller = new StudentController(studentRecord, view);

        System.out.println("--- Showing Initial Record ---");
        controller.updateView();

        // 4. Update model information securely via controller pipeline interfaces
        System.out.println("--- Modifying Record (Simulating Admin Update) ---");
        controller.setStudentGrade("A+");
        controller.setStudentName("Jane Doe");

        // 5. Present the refreshed view state
        System.out.println("--- Showing Updated Record ---");
        controller.updateView();
    }

    private static Student fetchStudentFromDatabase() {
        Student s = new Student();
        s.setName("Jane Smith");
        s.setId("STU-2026-99A");
        s.setGrade("A");
        return s;
    }
}