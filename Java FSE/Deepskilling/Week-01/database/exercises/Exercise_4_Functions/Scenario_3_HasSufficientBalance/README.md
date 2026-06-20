# Scenario 3: Check Sufficient Balance

## Description
This function checks whether a specific account has enough funds to cover a requested transaction amount.

## Function Details
- **Function Name:** `HasSufficientBalance`
- **Parameters:**
  - `p_account_id` (NUMBER): The ID of the account to check.
  - `p_amount` (NUMBER): The transaction amount to verify.
- **Logic:** - Retrieves the current balance.
  - Compares balance against the requested amount.
  - Returns `1` if balance is sufficient, `0` otherwise.
- **Return Type:** NUMBER (Acts as a Boolean).

## Verification
1. **Initial:** Query the `Accounts` table to display the starting balance.
2. **Execution:** Call the function for both an affordable amount (e.g., 500) and an unaffordable amount (e.g., 5000).
3. **Result:** Confirm that the output matches the expected logic (1 for true, 0 for false).