-- 1. INITIAL STATE
SELECT 'INITIAL STATE' as STATUS, AccountID, AccountType, Balance 
FROM Accounts 
WHERE AccountType = 'Savings';

-- 2. EXECUTION
BEGIN
    ProcessMonthlyInterest;
END;
/

-- 3. FINAL STATE
SELECT 'FINAL STATE' as STATUS, AccountID, AccountType, Balance 
FROM Accounts 
WHERE AccountType = 'Savings';
/