# Exercise 7: Packages

## Scenario 2: Create a Package to Manage Employee Data

### Objective

Create a package named `EmployeeManagement` that groups employee-related procedures and functions.

### Files Included

#### solution.sql

Contains:

* Package Specification
* Package Body
* Procedure `HireEmployee`
* Procedure `UpdateEmployee`
* Function `CalculateAnnualSalary`

#### verification.sql

Contains:

* Employee details before execution
* Execution of package procedures and function
* Employee details after execution

### Package Components

#### HireEmployee

Adds a new employee record to the Employees table.

#### UpdateEmployee

Updates employee position and salary.

#### CalculateAnnualSalary

Calculates and returns the annual salary of an employee.

### Concepts Used

* Package Specification
* Package Body
* Procedures
* Functions
* INSERT Statement
* UPDATE Statement
* SELECT INTO
* DBMS_OUTPUT

### Result

The EmployeeManagement package successfully manages employee-related operations and calculates annual salary using a function.
