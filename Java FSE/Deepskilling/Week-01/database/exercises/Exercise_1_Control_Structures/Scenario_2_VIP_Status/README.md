# Scenario 2: VIP Status Update
This script evaluates customer balances.
- Customers with a balance > $10,000 are set to IsVIP = 'TRUE'.
- All other customers are set to IsVIP = 'FALSE'.

## How to run
1. Ensure the `IsVIP` column exists in the `Customers` table.
2. Run `solution.sql` to apply the status.
3. Run `verification.sql` to check results.