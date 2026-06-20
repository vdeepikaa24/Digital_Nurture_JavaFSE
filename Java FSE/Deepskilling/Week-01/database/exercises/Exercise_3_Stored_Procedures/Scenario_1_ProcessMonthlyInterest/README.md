# Scenario 1: Monthly Interest Processing

## Description
This procedure automates the monthly banking task of applying interest to savings accounts. It identifies all accounts marked as 'Savings' and applies a 1% interest rate to their existing balance.

## Database Object
- **Procedure Name:** `ProcessMonthlyInterest`
- **Logic:** - Performs an `UPDATE` on the `Accounts` table.
  - Formula: `Balance = Balance + (Balance * 0.01)`
  - Filter: Only records where `AccountType` is 'Savings'.

## How to execute
1. **Setup:** Run the contents of `solution.sql` to compile the stored procedure in your database. Ensure your environment supports the `/` terminator.
2. **Execute:** Run the following command in your SQL terminal:

```sql
BEGIN
    ProcessMonthlyInterest;
END;
/