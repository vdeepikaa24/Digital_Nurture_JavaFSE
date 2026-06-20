# Scenario 2: Update Salary

## Description
This stored procedure increases an employee's salary by a specified percentage. It includes error handling to verify if the employee ID exists; if the ID is not found, the procedure logs an appropriate error message and prevents the update.

## Files
- `solution.sql`: Contains the `UpdateSalary` stored procedure definition.
- `verification.sql`: Tests both a successful salary update and a failure scenario (invalid employee ID).

## Execution Steps
1. Run `solution.sql` to compile the procedure.
2. Run `verification.sql` to observe the success and error logging behaviors.