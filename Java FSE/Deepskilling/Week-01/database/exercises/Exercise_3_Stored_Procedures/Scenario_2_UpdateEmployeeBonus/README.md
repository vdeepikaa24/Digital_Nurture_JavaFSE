# Scenario 2: Employee Bonus Calculation

## Description
This scenario implements a stored procedure to automate salary increases for employees based on their department. The procedure applies a specified percentage-based bonus to the current salary of all employees within a given department.

## Database Objects
- **Table:** `Employees`
  - Columns: `EmployeeID` (PK), `Name`, `Position`, `Salary`, `Department`, `HireDate`.
- **Procedure:** `UpdateEmployeeBonus`
  - Purpose: Updates the `Salary` column for all records matching the input `Department`.
  - Logic: `New Salary = Current Salary + (Current Salary * (Bonus Percentage / 100))`

## Execution Instructions
1. **Setup:** Ensure the `Employees` table is created and populated with data using your schema setup scripts.
2. **Compile:** Run the `solution.sql` file to create the `UpdateEmployeeBonus` procedure.
3. **Verify:** Run the `verification.sql` script to observe the salary state before and after the procedure execution.

## Verification Results
The following results demonstrate the procedure successfully applying a 10% bonus to the HR department:

| Status | EmployeeID | Department | Salary |
| :--- | :--- | :--- | :--- |
| BEFORE UPDATE | 1 | HR | 93170 |
| AFTER UPDATE | 1 | HR | 112735.7 |

*(Note: The procedure execution confirmed via: "PL/SQL procedure successfully completed.")*