-- 1. Setup: Clean the table
DELETE FROM TRANSACTIONS WHERE TransactionID IN (9001, 9002, 9003);
DELETE FROM AuditLog;
COMMIT;

-- 2. BEFORE state: Show the table is empty
SELECT * FROM AuditLog;

-- 3. Execution: Attempting to insert
INSERT INTO TRANSACTIONS (TransactionID, AccountID, TransactionDate, Amount, TransactionType) 
VALUES (9001, 1, SYSDATE, 100, 'Deposit');

COMMIT;

-- 4. AFTER state: Verify the trigger fired
SELECT * FROM AuditLog;