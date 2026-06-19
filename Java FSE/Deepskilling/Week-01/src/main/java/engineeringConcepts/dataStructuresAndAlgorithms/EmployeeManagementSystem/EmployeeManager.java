package engineeringConcepts.dataStructuresAndAlgorithms.EmployeeManagementSystem;

public class EmployeeManager {
    private Employee[] employees;
    private int size; //Tracks the current number of active employee records

    public EmployeeManager(int capacity){
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    /**
     * 1. Add Employee
     * Appends an employee to the next available slot in the array.
     */
    public boolean addEmployee(Employee emp){
        if(size >= employees.length){
            System.out.println("Error: Management System capacity reached. Cannot add " + emp.getName());
            return false;
        }
        employees[size] = emp;
        size++;
        return true;
    }

    /**
     * 2.Search Employee
     * Looks up an employee linearly using their unique employeeId.
     */
    public Employee searchEmployee(String employeeId){
        for(int i = 0; i < size; i++){
            if(employees[i].getEmployeeId().equalsIgnoreCase(employeeId)){
                return employees[i];
            }
        }
        return null; //Not found
    }

       /**
         * 3.Traverse Employees
         * Iterative over and prints all valid employee profiles currently tracked.
         */
        public void traverseEmployees(){
            if(size == 0){
                System.out.println("No emplyee records found.");
                return;
            }
            System.out.println("--- Current Employee Directory (" + size + " active) ---");
            for(int i = 0; i < size; i++){
                System.out.println(employees[i]);
            }
        }
    
        /**
         * 4.Delete Employee
         * Locates the target employee and shifts subsequent items left to close the gap)
         */
        public boolean deleteEmployee(String employeeId){
            int targetIndex = -1;

            //Locate the item
            for(int i = 0; i < size; i++){
                if(employees[i].getEmployeeId().equalsIgnoreCase(employeeId)){
                    targetIndex = i;
                    break;
                }
            }
            if(targetIndex == -1){
                System.out.println("Delete failed: Employee ID " + employeeId + " NOT FOUND.");
                return false;
            }

            //Shift elements to the left to clean up memeory and preserve sequentialindexing
            for(int i = targetIndex; i < size - 1; i++){
                employees[i] = employees[i + 1];
            }

            employees[size - 1] = null; //Clean up dangling reference
            size--;
            return true;
        }
}
