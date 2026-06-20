SET SERVEROUTPUT ON;

-- 1. Try to add a new ID (Success)
BEGIN AddNewCustomer(4, 'New User', SYSDATE, 500); END;
/

-- 2. Try to add an ID that already exists (Error Handling)
BEGIN AddNewCustomer(1, 'Duplicate User', SYSDATE, 0); END;
/