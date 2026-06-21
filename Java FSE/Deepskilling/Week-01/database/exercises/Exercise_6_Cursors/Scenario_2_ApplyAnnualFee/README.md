# Exercise 6: Cursors

## Scenario 2: Apply Annual Fee to All Accounts

### Objective

Create a PL/SQL block using an explicit cursor named `ApplyAnnualFee` to deduct an annual maintenance fee from all accounts.

### Files Included

#### solution.sql

* Declares an explicit cursor `ApplyAnnualFee`
* Retrieves all accounts using `FOR UPDATE`
* Deducts a fixed annual fee of 100 from each account
* Uses OPEN, FETCH, UPDATE, and CLOSE operations
* Commits the changes

#### verification.sql

* Displays account balances before execution
* Executes the cursor block
* Displays account balances after execution

### Cursor Concepts Used

* Explicit Cursor
* FOR UPDATE Cursor
* WHERE CURRENT OF
* OPEN
* FETCH
* CLOSE
* COMMIT

