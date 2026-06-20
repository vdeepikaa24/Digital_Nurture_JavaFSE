SET SERVEROUTPUT ON;

-- Check initial balances
SELECT 'BEFORE' as Status, AccountID, Balance FROM Accounts WHERE AccountID IN (1, 2);

-- Execute a test transfer
EXEC SafeTransferFunds(1, 2, 200);

-- Check final balances
SELECT 'AFTER' as Status, AccountID, Balance FROM Accounts WHERE AccountID IN (1, 2);

-- Test a failure (Insufficient Funds)
EXEC SafeTransferFunds(1, 2, 99999);