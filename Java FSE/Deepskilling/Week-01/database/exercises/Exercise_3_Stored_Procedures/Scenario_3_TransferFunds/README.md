# Scenario 3: Transfer Funds Between Accounts

## Description
This procedure enables secure fund transfers between two accounts. It ensures data integrity by verifying that the source account has sufficient funds before performing the transaction and uses row-level locking to prevent concurrent update conflicts.

## Database Objects
- **Procedure Name:** `TransferFunds`
- **Parameters:**
  - `p_from_account` (NUMBER): The AccountID of the source.
  - `p_to_account` (NUMBER): The AccountID of the destination.
  - `p_amount` (NUMBER): The amount to be transferred.
- **Logic:**
  1. Locks the source account row (`FOR UPDATE`).
  2. Checks if `Balance >= p_amount`.
  3. Deducts from the source and adds to the destination.
  4. Commits the transaction if successful, or rolls back if an error occurs.

## How to execute
1. **Setup:** Run `solution.sql` to compile the procedure in your database.
2. **Execute:** Run the following command in your SQL terminal:

```sql
BEGIN
    TransferFunds(1, 2, 200);
END;
/