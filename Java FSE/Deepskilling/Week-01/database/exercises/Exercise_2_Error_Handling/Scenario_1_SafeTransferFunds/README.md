# Scenario 1: Safe Transfer of Funds

## Description
This stored procedure, `SafeTransferFunds`, handles the transfer of money between two accounts. It includes error handling to ensure that:
1. The transaction is aborted if the sender has insufficient funds.
2. The transaction is atomic (using ROLLBACK if any part of the process fails).

## Files
- `solution.sql`: Contains the `SafeTransferFunds` procedure logic.
- `verification.sql`: Contains test cases to verify success and failure scenarios.

## Execution Steps
1. Run `solution.sql` to create the procedure.
2. Run `verification.sql` to test the logic.