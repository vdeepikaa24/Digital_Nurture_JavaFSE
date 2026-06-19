# Scenario 3: Loan Reminders

This module identifies customers whose loans are approaching their maturity date.

## Purpose
The objective is to proactively notify customers by generating a reminder message for all loans that are scheduled to end within the next 30 days.

## Functionality
- Fetches loan records where the `EndDate` is between `SYSDATE` and `SYSDATE + 30`.
- Joins the `Loans` and `Customers` tables to retrieve customer contact information.
- Uses a PL/SQL block to iterate through the results and display a personalized reminder message.

## How to Run
1. Ensure the `Loans` and `Customers` tables are populated.
2. Execute `solution.sql` in your SQL environment.
3. Use `verification.sql` to list all upcoming loan maturities and verify the reminder logic.

## Files
- `solution.sql`    : The PL/SQL block for generating reminders.
- `verification.sql`: Query to view loan due dates for testing purposes.