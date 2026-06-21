SET DEFINE OFF;
SET FEEDBACK ON;

-- 1. Insert Parents
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
SELECT 1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE 
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM Customers WHERE CustomerID = 1);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
SELECT 2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE 
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM Customers WHERE CustomerID = 2);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
SELECT 3, 'Arthur Senior', TO_DATE('1960-01-01', 'YYYY-MM-DD'), 15000, SYSDATE 
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM Customers WHERE CustomerID = 3);

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
SELECT 1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD') 
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM Employees WHERE EmployeeID = 1);

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
SELECT 2, 'Bob Smith', 'Developer', 80000, 'HR', TO_DATE('2018-01-10', 'YYYY-MM-DD') 
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM Employees WHERE EmployeeID = 2);

-- 2. Insert Children
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
SELECT 1, 1, 'Savings', 1000, SYSDATE 
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM Accounts WHERE AccountID = 1);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
SELECT 2, 2, 'Checking', 1500, SYSDATE 
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM Accounts WHERE AccountID = 2);

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
SELECT 1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60) 
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM Loans WHERE LoanID = 1);

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
SELECT 3, 2, 8000, 5, SYSDATE, SYSDATE + 25 
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM Loans WHERE LoanID = 3);

-- 3. Insert Grand-Children
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
SELECT 1, 1, SYSDATE, 200, 'Deposit' 
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM Transactions WHERE TransactionID = 1);

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
SELECT 2, 2, SYSDATE, 300, 'Withdrawal' 
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM Transactions WHERE TransactionID = 2);

-- 4. GUARANTEED TEST CASE (This will always fire the trigger)
DELETE FROM Transactions WHERE TransactionID = 999;
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) 
VALUES (999, 1, SYSDATE, 999, 'Test');

COMMIT;