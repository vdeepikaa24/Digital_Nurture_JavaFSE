# Exercise: UpdateCustomerLastModified Trigger

## Description
This exercise requires creating a `BEFORE UPDATE` trigger on the `CUSTOMERS` table. 
The trigger ensures that the `LastModified` column is automatically set to the current date and time (`SYSDATE`) whenever any row in the `CUSTOMERS` table is updated.

## Files
- `solution.sql`: Contains the `CREATE OR REPLACE TRIGGER` statement.
- `verification.sql`: Contains an `UPDATE` statement followed by a `SELECT` to verify the trigger worked.