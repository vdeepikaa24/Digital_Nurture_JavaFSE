# Bank Transaction Audit and Rules Project

## Description
This project implements database triggers to manage banking transaction integrity.
- **Audit Logging:** Automatically logs all new transactions into an `AuditLog` table.
- **Business Rules:** Enforces constraints on deposits (must be positive) and withdrawals (must not exceed account balance).

## Database Objects
- `AuditLog` (Table): Stores transaction history.
- `LogTransaction` (Trigger): Captures inserts into `TRANSACTIONS`.
- `CheckTransactionRules` (Trigger): Validates deposit/withdrawal logic before insertion.

## How to Run
1. Log into your Oracle SQL instance as `DEMO_USER`.
2. Run the setup script: 
   `@solution.sql`
3. Run the verification script to test the logic:
   `@verification.sql`