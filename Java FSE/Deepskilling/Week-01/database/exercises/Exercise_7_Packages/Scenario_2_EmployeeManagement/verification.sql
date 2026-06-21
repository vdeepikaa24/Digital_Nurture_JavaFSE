SET SERVEROUTPUT ON;

SELECT * FROM Employees;

BEGIN

EmployeeManagement.HireEmployee(
    101,
    'David Miller',
    'Developer',
    50000,
    'IT'
);

EmployeeManagement.UpdateEmployee(
    101,
    'Senior Developer',
    60000
);

DBMS_OUTPUT.PUT_LINE(
    'Annual Salary = ' ||
    EmployeeManagement.CalculateAnnualSalary(101)
);

COMMIT;

END;
/

SELECT *
FROM Employees
WHERE EmployeeID = 101;
/