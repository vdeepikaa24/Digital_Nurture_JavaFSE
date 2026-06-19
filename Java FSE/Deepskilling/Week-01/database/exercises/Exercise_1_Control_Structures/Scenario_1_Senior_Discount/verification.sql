SET SERVEROUTPUT ON;
-- 1. Show everyone BEFORE the update
SELECT Name, LoanID, InterestRate FROM Loans L 
JOIN Customers C ON L.CustomerID = C.CustomerID;

