SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_acc IN NUMBER, 
    p_to_acc IN NUMBER, 
    p_amount IN NUMBER
) AS
    v_source_balance NUMBER;
BEGIN
    -- 1. Attempt to lock the source account and get balance
    SELECT Balance INTO v_source_balance 
    FROM Accounts 
    WHERE AccountID = p_from_acc 
    FOR UPDATE;
    
    -- 2. Check for sufficient funds
    IF v_source_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds. Transfer aborted.');
    END IF;

    -- 3. Perform the transfer
    UPDATE Accounts SET Balance = Balance - p_amount, LastModified = SYSDATE 
    WHERE AccountID = p_from_acc;
    
    UPDATE Accounts SET Balance = Balance + p_amount, LastModified = SYSDATE 
    WHERE AccountID = p_to_acc;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_amount || ' from Account ' || p_from_acc || ' to ' || p_to_acc);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: One of the accounts does not exist.');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK;
END;
/