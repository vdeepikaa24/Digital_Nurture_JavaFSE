CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_id IN NUMBER,
    p_name IN VARCHAR2,
    p_dob IN DATE,
    p_balance IN NUMBER
)
AS
BEGIN
    -- Attempt the insertion
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
    VALUES (p_id, p_name, p_dob, p_balance, SYSDATE, 'FALSE');
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer ' || p_name || ' added successfully.');
    
EXCEPTION
    -- This specific exception handles the Primary Key violation
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_id || ' already exists. Insertion prevented.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An unexpected error occurred: ' || SQLERRM);
END;
/