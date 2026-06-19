-- Clear old table data safely
DELETE FROM Loans; 
DELETE FROM Customers;
DELETE FROM ACCOUNTS;

-- Insert exact sample customer rows matching your classmate's setup
INSERT INTO Customers (CustomerID, Name, Age, Balance, IsVIP) VALUES (3, 'Priya', 70, 20000, 'FALSE');
INSERT INTO Customers (CustomerID, Name, Age, Balance, IsVIP) VALUES (1, 'Sanjai', 65, 15000, 'FALSE');
INSERT INTO Customers (CustomerID, Name, Age, Balance, IsVIP) VALUES (2, 'Rahul', 45, 8000, 'FALSE');
INSERT INTO Customers (CustomerID, Name, Age, Balance, IsVIP) VALUES (4, 'Kumar', 55, 12000, 'FALSE');

-- Insert exact sample loan records matching your classmate's setup
INSERT INTO Loans (LoanID, CustomerID, InterestRate, DueDate) VALUES (101, 1, 9, TO_DATE('2026-07-15', 'YYYY-MM-DD'));
INSERT INTO Loans (LoanID, CustomerID, InterestRate, DueDate) VALUES (102, 2, 12, TO_DATE('2026-08-20', 'YYYY-MM-DD'));
INSERT INTO Loans (LoanID, CustomerID, InterestRate, DueDate) VALUES (103, 3, 10, TO_DATE('2026-07-25', 'YYYY-MM-DD'));
INSERT INTO Loans (LoanID, CustomerID, InterestRate, DueDate) VALUES (104, 4, 9, TO_DATE('2026-09-05', 'YYYY-MM-DD'));

-- Insert account data
INSERT INTO ACCOUNTS (ACCOUNTID, BALANCE) VALUES (1, 15000);
INSERT INTO ACCOUNTS (ACCOUNTID, BALANCE) VALUES (2, 8000);

COMMIT;