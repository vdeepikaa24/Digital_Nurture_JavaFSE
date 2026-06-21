# Exercise 6: Cursors

## Scenario 1: Generate Monthly Statements for All Customers

### Objective

Create a PL/SQL block using an explicit cursor named `GenerateMonthlyStatements` to retrieve all transactions performed during the current month and print a statement for each customer.

### Files Included

#### solution.sql

Contains the PL/SQL block that:

* Declares an explicit cursor `GenerateMonthlyStatements`
* Retrieves customer and transaction details for the current month
* Uses OPEN, FETCH, and CLOSE operations
* Displays the statement using `DBMS_OUTPUT.PUT_LINE`

#### verification.sql

Contains:

* Sample transaction records for testing
* Execution of the cursor block

### Cursor Concepts Used

* Explicit Cursor Declaration
* OPEN Cursor
* FETCH Records
* EXIT WHEN %NOTFOUND
* CLOSE Cursor

### Expected Output

MONTHLY CUSTOMER STATEMENTS

---

Customer ID: 1, Name: John Doe, Transaction ID: 101, Date: 21-JUN-2026, Type: Deposit, Amount: 5000

Customer ID: 1, Name: John Doe, Transaction ID: 102, Date: 21-JUN-2026, Type: Withdrawal, Amount: 1000

### Result

The explicit cursor successfully retrieves all transactions for the current month and prints monthly statements for customers.
