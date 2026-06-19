BEGIN
    FOR rec IN (
        SELECT L.LoanID
        FROM Loans L
        JOIN Customers c ON L.CustomerID = c.CustomerID
        WHERE c.Age > 60
    ) LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = rec.LoanID;
    END LOOP;
    
    COMMIT;
END;
/