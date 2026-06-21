-- 1. Drop tables in reverse order of dependencies to avoid constraint errors
DROP TABLE AuditLog CASCADE CONSTRAINTS;
DROP TABLE TRANSACTIONS CASCADE CONSTRAINTS;
DROP TABLE ACCOUNTS CASCADE CONSTRAINTS;
DROP TABLE CUSTOMERS CASCADE CONSTRAINTS;

-- 2. Create tables
CREATE TABLE CUSTOMERS (
    CustomerID NUMBER PRIMARY KEY, 
    Name VARCHAR2(100), 
    DOB DATE, 
    Balance NUMBER(15,2), 
    LastModified DATE, 
    IsVIP VARCHAR2(5) DEFAULT 'FALSE'
);

CREATE TABLE ACCOUNTS (
    AccountID NUMBER PRIMARY KEY, 
    CustomerID NUMBER, 
    AccountType VARCHAR2(20), 
    Balance NUMBER(15,2), 
    LastModified DATE, 
    CONSTRAINT fk_customer FOREIGN KEY (CustomerID) REFERENCES CUSTOMERS(CustomerID)
);

CREATE TABLE TRANSACTIONS (
    TransactionID NUMBER PRIMARY KEY, 
    AccountID NUMBER, 
    TransactionDate DATE, 
    Amount NUMBER(15,2), 
    TransactionType VARCHAR2(10), 
    CONSTRAINT fk_account FOREIGN KEY (AccountID) REFERENCES ACCOUNTS(AccountID)
);

CREATE TABLE AuditLog (
    LogID NUMBER PRIMARY KEY, 
    TransactionID NUMBER, 
    LogDate DATE DEFAULT SYSDATE, 
    Action VARCHAR2(50),
    CONSTRAINT fk_log_tx FOREIGN KEY (TransactionID) REFERENCES TRANSACTIONS(TransactionID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER(15,2),
    Department VARCHAR2(50),
    HireDate DATE
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER(15,2),
    InterestRate NUMBER(5,2),
    StartDate DATE,
    EndDate DATE,
    CONSTRAINT fk_loan_customer FOREIGN KEY (CustomerID) REFERENCES CUSTOMERS(CustomerID)
);

COMMIT;
/