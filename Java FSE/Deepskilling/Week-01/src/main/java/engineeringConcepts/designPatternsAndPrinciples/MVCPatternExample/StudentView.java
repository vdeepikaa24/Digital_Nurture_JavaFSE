package engineeringConcepts.designPatternsAndPrinciples.MVCPatternExample;

public class StudentView {
    public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
        System.out.println("========================================");
        System.out.println("            STUDENT PROFILE             ");
        System.out.println("========================================");
        System.out.println("ID     : " + studentId);
        System.out.println("Name   : " + studentName);
        System.out.println("Grade  : " + studentGrade);
        System.out.println("========================================\n");
    }
}