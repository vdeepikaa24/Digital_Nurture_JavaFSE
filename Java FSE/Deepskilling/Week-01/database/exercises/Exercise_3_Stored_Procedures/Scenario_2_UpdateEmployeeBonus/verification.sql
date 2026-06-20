-- 1. Check data BEFORE
SELECT 'BEFORE UPDATE' as STATUS, EmployeeID, Department, Salary 
FROM Employees 
WHERE Department = 'HR';

-- 2. Execute Procedure (10% bonus for HR)
BEGIN
    UpdateEmployeeBonus('HR', 10);
END;
/

-- 3. Check data AFTER
SELECT 'AFTER UPDATE' as STATUS, EmployeeID, Department, Salary 
FROM Employees 
WHERE Department = 'HR';
/