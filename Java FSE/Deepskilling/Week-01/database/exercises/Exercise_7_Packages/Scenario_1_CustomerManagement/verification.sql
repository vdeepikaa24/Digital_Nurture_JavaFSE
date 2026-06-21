SET SERVEROUTPUT ON;

SELECT * FROM Customers;

BEGIN

    CustomerManagement.AddCustomer(
        101,
        'Alice Johnson',
        DATE '1995-06-15',
        5000
    );

    CustomerManagement.UpdateCustomer(
        101,
        'Alice Smith'
    );

    DBMS_OUTPUT.PUT_LINE(
        'Customer Balance = ' ||
        CustomerManagement.GetCustomerBalance(101)
    );

    COMMIT;

END;
/

SELECT * FROM Customers
WHERE CustomerID = 101;