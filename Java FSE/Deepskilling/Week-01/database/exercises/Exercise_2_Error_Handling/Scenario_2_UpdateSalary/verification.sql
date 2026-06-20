DELETE FROM Employees;
INSERT INTO Employees VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', SYSDATE);
COMMIT;

SET SERVEROUTPUT ON;

BEGIN 
    DBMS_OUTPUT.PUT_LINE('Before update'); 
END;
/
SELECT EmployeeID, Name, Salary FROM Employees WHERE EmployeeID = 1;

BEGIN 
    UpdateSalary(1, 10); 
END;
/

BEGIN 
    DBMS_OUTPUT.PUT_LINE('Check again'); 
END;
/
SELECT EmployeeID, Name, Salary FROM Employees WHERE EmployeeID = 1;

BEGIN 
    DBMS_OUTPUT.PUT_LINE('Invalid employee'); 
    UpdateSalary(999, 10); 
END;
/