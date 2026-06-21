CREATE TABLE CUSTOMERS (
    CustomerID NUMBER PRIMARY KEY, 
    Name VARCHAR2(100), 
    DOB DATE, 
    Balance NUMBER, 
    LastModified DATE, 
    IsVIP VARCHAR2(5) DEFAULT 'FALSE'
);
/
CREATE TABLE ACCOUNTS (
    AccountID NUMBER PRIMARY KEY, 
    CustomerID NUMBER, 
    AccountType VARCHAR2(20), 
    Balance NUMBER, 
    LastModified DATE, 
    CONSTRAINT fk_customer FOREIGN KEY (CustomerID) REFERENCES CUSTOMERS(CustomerID)
);
/
CREATE TABLE TRANSACTIONS (
    TransactionID NUMBER PRIMARY KEY, 
    AccountID NUMBER, 
    TransactionDate DATE, 
    Amount NUMBER, 
    TransactionType VARCHAR2(10), 
    CONSTRAINT fk_account FOREIGN KEY (AccountID) REFERENCES ACCOUNTS(AccountID)
);
/
CREATE TABLE LOANS (
    LoanID NUMBER PRIMARY KEY, 
    CustomerID NUMBER, 
    LoanAmount NUMBER, 
    InterestRate NUMBER, 
    StartDate DATE, 
    EndDate DATE, 
    CONSTRAINT fk_loan_customer FOREIGN KEY (CustomerID) REFERENCES CUSTOMERS(CustomerID)
);
/
CREATE TABLE EMPLOYEES (
    EmployeeID NUMBER PRIMARY KEY, 
    Name VARCHAR2(100), 
    Position VARCHAR2(50), 
    Salary NUMBER, 
    Department VARCHAR2(50), 
    HireDate DATE
);
/