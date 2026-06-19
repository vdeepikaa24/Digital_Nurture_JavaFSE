SET SERVEROUTPUT ON;

BEGIN
    -- The cursor explicitly selects loans where the due date is 
    -- between today (SYSDATE) and 30 days from now (SYSDATE + 30).
    FOR rec IN (
        SELECT c.Name, l.LoanID, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate >= SYSDATE 
          AND l.EndDate <= SYSDATE + 30
    ) 
    LOOP
        -- This prints the requested reminder message for each customer
        DBMS_OUTPUT.PUT_LINE('REMINDER: Dear ' || rec.Name || ', your loan (ID: ' || 
                             rec.LoanID || ') is due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD') || '.');
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('Reminder process complete.');
END;
/