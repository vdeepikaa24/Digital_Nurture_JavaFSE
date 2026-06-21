# Exercise 6: Cursors

## Scenario 3: Update the Interest Rate for All Loans Based on a New Policy

### Objective

Create a PL/SQL block using an explicit cursor named `UpdateLoanInterestRates` that fetches all loan records and updates their interest rates according to a new policy.

### Files Included

#### solution.sql

Contains the PL/SQL block that:

* Declares an explicit cursor `UpdateLoanInterestRates`
* Retrieves all loan records from the `Loans` table
* Updates the interest rate of each loan
* Displays the updated loan details
* Commits the changes to the database

#### verification.sql

Contains:

* Query to display loan details before execution
* Execution of the cursor block
* Query to display loan details after execution

### Cursor Concepts Used

* Explicit Cursor Declaration
* OPEN Cursor
* FETCH Records
* EXIT WHEN `%NOTFOUND`
* UPDATE Statement
* CLOSE Cursor
* COMMIT

### Business Rule

The new policy increases the interest rate of every loan by 0.5%.

### Result

The explicit cursor successfully fetched all loan records and updated their interest rates according to the new policy.
