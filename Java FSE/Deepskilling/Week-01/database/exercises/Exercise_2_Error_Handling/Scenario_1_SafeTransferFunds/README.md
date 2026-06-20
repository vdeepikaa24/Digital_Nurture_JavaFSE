# Scenario 1: Safe Transfer Funds

## Description
This stored procedure facilitates a secure fund transfer between two accounts. It includes robust error handling to validate account existence and ensure sufficient funds, using `ROLLBACK` to maintain data integrity if any part of the transaction fails.

## Files
- `solution.sql`: Contains the `SafeTransferFunds` stored procedure definition.
- `verification.sql`: Tests both successful transfers and insufficient-fund scenarios to verify atomicity.

## Execution Steps
1. Run `solution.sql` to compile the procedure.
2. Run `verification.sql` to observe the success and rollback behaviors.