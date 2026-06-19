CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_acc IN NUMBER,
    p_to_acc IN NUMBER,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    SELECT BALANCE INTO v_balance FROM ACCOUNTS WHERE ACCOUNTID = p_from_acc;
    
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
    END IF;

    UPDATE ACCOUNTS SET BALANCE = BALANCE - p_amount WHERE ACCOUNTID = p_from_acc;
    UPDATE ACCOUNTS SET BALANCE = BALANCE + p_amount WHERE ACCOUNTID = p_to_acc;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer successful.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/