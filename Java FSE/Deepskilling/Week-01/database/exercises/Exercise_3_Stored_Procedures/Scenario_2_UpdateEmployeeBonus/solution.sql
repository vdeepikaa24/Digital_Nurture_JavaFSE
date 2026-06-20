CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_dept_name IN VARCHAR2, 
    p_bonus_percent IN NUMBER
)
AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * (p_bonus_percent / 100))
    WHERE Department = p_dept_name; 
END;
/