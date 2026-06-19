CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_emp_id IN NUMBER,
    p_percentage IN NUMBER
) AS
    v_rows_affected NUMBER;
BEGIN
    UPDATE Employees 
    SET Salary = Salary + (Salary * (p_percentage / 100))
    WHERE EmployeeID = p_emp_id;

    v_rows_affected := SQL%ROWCOUNT;

    IF v_rows_affected = 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Error: Employee ID ' || p_emp_id || ' does not exist.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Salary updated successfully for Employee ID ' || p_emp_id);
        COMMIT;
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Logging Error: ' || SQLERRM);
        ROLLBACK;
END;
/