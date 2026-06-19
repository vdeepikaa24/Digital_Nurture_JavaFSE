SET SERVEROUTPUT ON;

BEGIN
    -- Set IsVIP to TRUE for customers with balance over 10,000
    UPDATE CUSTOMERS 
    SET ISVIP = 'TRUE' 
    WHERE BALANCE > 10000;
    
    DBMS_OUTPUT.PUT_LINE('VIP promotion updated ' || SQL%ROWCOUNT || ' customers.');
    COMMIT;
END;
/