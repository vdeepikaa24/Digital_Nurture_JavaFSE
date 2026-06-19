-- Apply 1% discount to interest rate for customers over 60
BEGIN
    FOR rec IN (
        SELECT L.LoanID, L.InterestRate, C.DOB 
        FROM Loans L 
        JOIN Customers C ON L.CustomerID = C.CustomerID
    ) LOOP
        -- Check if age is greater than 60
        IF FLOOR(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12) > 60 THEN
            UPDATE Loans 
            SET InterestRate = rec.InterestRate * 0.99
            WHERE LoanID = rec.LoanID;
        END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Senior discount applied successfully.');
END;
/