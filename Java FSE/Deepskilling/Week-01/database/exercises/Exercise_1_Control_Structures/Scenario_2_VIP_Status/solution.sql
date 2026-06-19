SET SERVEROUTPUT ON;

BEGIN
    FOR rec IN (SELECT CustomerID, Balance FROM Customers) 
    LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers 
            SET IsVIP = 'TRUE' 
            WHERE CustomerID = rec.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('Customer ID ' || rec.CustomerID || ' is now a VIP.');
        END IF;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status update complete.');
END;
/