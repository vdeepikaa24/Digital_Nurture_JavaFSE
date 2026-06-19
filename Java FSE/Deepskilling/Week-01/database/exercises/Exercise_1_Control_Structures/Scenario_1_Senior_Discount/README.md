# Scenario 1: Senior Discount

## Description
This procedure applies a 1% interest rate discount to any customer over the age of 60. It calculates the age dynamically using the `DOB` field from the `Customers` table and updates the `InterestRate` in the `Loans` table.

## Files
- `solution.sql`: Contains the PL/SQL block to update loan interest rates.
- `verification.sql`: Verifies the interest rates before and after the update.

## Execution Steps
1. Run `verification.sql` in your SQL tool.
2. The output will show the interest rate values, trigger the update, and display the new rates.