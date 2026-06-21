CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON TRANSACTIONS
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    -- Rule 1: Deposits must be positive
    IF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
    END IF;

    -- Rule 2: Check balance for withdrawals
    IF :NEW.TransactionType = 'Withdrawal' THEN
        -- Get the current balance for this account
        SELECT Balance INTO v_balance 
        FROM ACCOUNTS 
        WHERE AccountID = :NEW.AccountID;

        -- If withdrawal amount exceeds balance, abort
        IF :NEW.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20003, 'Insufficient funds for withdrawal.');
        END IF;
    END IF;
END;
/