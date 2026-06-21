# Exercise 7: Packages

## Scenario 3: Group All Account-Related Operations into a Package

### Objective

Create a package named `AccountOperations` that groups account-related procedures and functions.

### Files Included

#### solution.sql

Contains:
- Package Specification
- Package Body
- Procedure `OpenAccount`
- Procedure `CloseAccount`
- Function `GetTotalBalance`

#### verification.sql

Contains:
- Account details before execution
- Execution of package procedures and function
- Account details after execution

### Package Components

#### OpenAccount
Creates a new account for a customer.

#### CloseAccount
Closes an existing account by deleting it from the Accounts table.

#### GetTotalBalance
Returns the total balance across all accounts belonging to a customer.

### Concepts Used

- Package Specification
- Package Body
- Procedures
- Functions
- INSERT Statement
- DELETE Statement
- SELECT INTO
- Aggregate Function (SUM)
- DBMS_OUTPUT

### Result

The AccountOperations package successfully manages account-related operations and calculates the total balance across all accounts of a customer.