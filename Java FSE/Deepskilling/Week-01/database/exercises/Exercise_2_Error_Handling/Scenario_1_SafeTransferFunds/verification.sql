SET SERVEROUTPUT ON;

-- 1. Initial State 
SELECT * FROM Employees;

-- 2. Execute Updates 
-- You will see the confirmation message, then the error log
EXEC UpdateSalary(1, 10);
EXEC UpdateSalary(99, 10);

-- 3. Final State
-- Alice should now have 55000
SELECT * FROM Employees;