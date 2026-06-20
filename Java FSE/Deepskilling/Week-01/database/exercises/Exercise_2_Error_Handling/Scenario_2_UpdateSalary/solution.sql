CREATE OR REPLACE PROCEDURE UpdateSalary(p_emp_id IN NUMBER, p_percent IN NUMBER) AS
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count FROM Employees WHERE EmployeeID = p_emp_id;
    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_emp_id || ' does not exist.');
    ELSE
        UPDATE Employees SET Salary = Salary + (Salary * p_percent / 100) WHERE EmployeeID = p_emp_id;
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Salary updated successfully for Employee ID ' || p_emp_id);
    END IF;
END;
/