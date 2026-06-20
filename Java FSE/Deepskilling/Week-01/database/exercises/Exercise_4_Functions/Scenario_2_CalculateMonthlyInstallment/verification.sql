-- 1. INITIAL: Show loan parameters
SELECT 'INITIAL' as STATUS, LoanID, LoanAmount, InterestRate 
FROM Loans WHERE LoanID = 1;

-- 2. EXECUTION & FINAL RESULT: Apply the function
SELECT 'EXECUTION' as STATUS, 
       LoanID,
       CalculateMonthlyInstallment(LoanAmount, InterestRate, 5) as MONTHLY_INSTALLMENT
FROM Loans WHERE LoanID = 1;