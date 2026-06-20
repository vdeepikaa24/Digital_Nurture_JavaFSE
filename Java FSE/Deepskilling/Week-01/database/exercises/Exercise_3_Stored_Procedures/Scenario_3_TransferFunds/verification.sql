-- Check balance before
SELECT AccountID, Balance FROM Accounts WHERE AccountID IN (1, 2);

-- Perform transfer
BEGIN
    TransferFunds(1, 2, 200); -- Transfer 200 from Acc 1 to Acc 2
END;
/

-- Check balance after
SELECT AccountID, Balance FROM Accounts WHERE AccountID IN (1, 2);