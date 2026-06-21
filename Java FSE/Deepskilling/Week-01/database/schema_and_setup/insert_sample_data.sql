SET DEFINE OFF;
SET FEEDBACK ON;

-- 1. Insert Parents (Triggers usually aren't needed here)
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
SELECT 1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE 
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM Customers WHERE CustomerID = 1);

ALTER TABLE TRANSACTIONS DISABLE ALL TRIGGERS;

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
SELECT 1, 1, SYSDATE, 200, 'Deposit' 
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM Transactions WHERE TransactionID = 1);

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
SELECT 2, 2, SYSDATE, 300, 'Withdrawal' 
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM Transactions WHERE TransactionID = 2);

-- 4. GUARANTEED TEST CASE
DELETE FROM Transactions WHERE TransactionID = 999;
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) 
VALUES (999, 1, SYSDATE, 999, 'Test');

-- Re-enable triggers after the transaction inserts are finished
ALTER TABLE TRANSACTIONS ENABLE ALL TRIGGERS;

COMMIT;
/