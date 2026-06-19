-- Drop old tables if they exist to prevent name conflicts
DROP TABLE Loans CASCADE CONSTRAINTS;
DROP TABLE Customers CASCADE CONSTRAINTS;
DROP TABLE ACCOUNTS CASCADE CONSTRAINTS; 

-- 1. Customers Table
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Age NUMBER,
    Balance NUMBER,
    IsVIP VARCHAR2(10) DEFAULT 'FALSE'
);

-- 2. Loans Table
CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    InterestRate NUMBER,
    DueDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- 3. ACCOUNTS Table
CREATE TABLE ACCOUNTS (
    ACCOUNTID NUMBER PRIMARY KEY,
    BALANCE NUMBER
);