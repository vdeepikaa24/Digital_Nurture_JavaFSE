SET SERVEROUTPUT ON;

SELECT
c.CustomerID,
c.Name,
t.TransactionID,
t.TransactionDate,
t.TransactionType,
t.Amount
FROM Customers c
JOIN Accounts a
ON c.CustomerID = a.CustomerID
JOIN Transactions t
ON a.AccountID = t.AccountID
WHERE TO_CHAR(t.TransactionDate, 'MMYYYY') =
TO_CHAR(SYSDATE, 'MMYYYY')
ORDER BY c.CustomerID, t.TransactionDate;

SELECT
c.CustomerID,
c.Name,
t.TransactionID,
t.TransactionDate,
t.TransactionType,
t.Amount
FROM Customers c
JOIN Accounts a
ON c.CustomerID = a.CustomerID
JOIN Transactions t
ON a.AccountID = t.AccountID
WHERE TO_CHAR(t.TransactionDate, 'MMYYYY') =
TO_CHAR(SYSDATE, 'MMYYYY')
ORDER BY c.CustomerID, t.TransactionDate;