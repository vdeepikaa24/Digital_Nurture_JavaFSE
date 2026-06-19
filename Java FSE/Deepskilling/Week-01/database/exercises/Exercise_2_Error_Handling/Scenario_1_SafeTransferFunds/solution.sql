SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_acc IN INT, 
    p_to_acc IN INT, 
    p_amount IN NUMBER
) IS
    v_balance NUMBER;
BEGIN
    -- Check balance in ACCOUNTS table
    SELECT BALANCE INTO v_balance FROM ACCOUNTS WHERE ACCOUNTID = p_from_acc;
    
    -- Error handling for insufficient funds
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds for transfer.');
    END IF;

    -- Perform the transfer
    UPDATE ACCOUNTS SET BALANCE = BALANCE - p_amount WHERE ACCOUNTID = p_from_acc;
    UPDATE ACCOUNTS SET BALANCE = BALANCE + p_amount WHERE ACCOUNTID = p_to_acc;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer successful.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
/