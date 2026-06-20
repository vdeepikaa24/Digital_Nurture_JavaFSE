CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id IN NUMBER, 
    p_amount IN NUMBER
) RETURN NUMBER AS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_account_id;
    
    -- Returns 1 for TRUE (sufficient), 0 for FALSE (insufficient)
    IF v_balance >= p_amount THEN
        RETURN 1;
    ELSE
        RETURN 0;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;
/