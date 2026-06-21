-- Clean up old test data
DELETE FROM TRANSACTIONS WHERE TransactionID = 8888;
DELETE FROM AuditLog;
COMMIT;

-- Run the test
INSERT INTO TRANSACTIONS (TransactionID, AccountID, TransactionDate, Amount, TransactionType) 
VALUES (8888, 1, SYSDATE, 99.99, 'Deposit');
COMMIT;

-- Verify
SELECT * FROM AuditLog;