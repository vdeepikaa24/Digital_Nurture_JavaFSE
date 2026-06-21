SET SERVEROUTPUT ON;

DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_AccountID Accounts.AccountID%TYPE;
    v_Balance   Accounts.Balance%TYPE;

    annual_fee CONSTANT NUMBER := 100;

BEGIN
    OPEN ApplyAnnualFee;

    LOOP
        FETCH ApplyAnnualFee
        INTO v_AccountID, v_Balance;

        EXIT WHEN ApplyAnnualFee%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - annual_fee
        WHERE AccountID = v_AccountID;

        DBMS_OUTPUT.PUT_LINE(
            'Annual fee deducted from Account ID: ' ||
            v_AccountID
        );
    END LOOP;

    CLOSE ApplyAnnualFee;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Annual fee applied successfully.');
END;
/