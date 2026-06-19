SET SERVEROUTPUT ON;

BEGIN
    -- Fetch loans due in the next 30 days
    FOR loan_rec IN (SELECT CUSTOMERID, LOANID, DUEDATE 
                     FROM LOANS 
                     WHERE DUEDATE BETWEEN SYSDATE AND SYSDATE + 30) 
    LOOP
        DBMS_OUTPUT.PUT_LINE('REMINDER: Customer ' || loan_rec.CUSTOMERID || 
                             ' has Loan ' || loan_rec.LOANID || 
                             ' due on ' || TO_CHAR(loan_rec.DUEDATE, 'DD-MON-YYYY'));
    END LOOP;
END;
/