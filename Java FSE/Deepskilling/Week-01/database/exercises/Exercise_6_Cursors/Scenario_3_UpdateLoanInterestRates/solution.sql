SET SERVEROUTPUT ON;

DECLARE

    CURSOR UpdateLoanInterestRates IS
        SELECT LOANID, INTERESTRATE
        FROM LOANS;

    v_LoanID LOANS.LOANID%TYPE;
    v_InterestRate LOANS.INTERESTRATE%TYPE;

BEGIN

    OPEN UpdateLoanInterestRates;

    LOOP

        FETCH UpdateLoanInterestRates
        INTO v_LoanID, v_InterestRate;

        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

        UPDATE LOANS
        SET INTERESTRATE = INTERESTRATE + 0.5
        WHERE LOANID = v_LoanID;

        DBMS_OUTPUT.PUT_LINE(
            'Loan ID: ' || v_LoanID ||
            ' updated successfully.'
        );

    END LOOP;

    CLOSE UpdateLoanInterestRates;

    COMMIT;

END;
/