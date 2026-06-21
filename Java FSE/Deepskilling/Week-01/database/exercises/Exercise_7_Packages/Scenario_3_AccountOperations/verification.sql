SET SERVEROUTPUT ON;

SELECT * FROM Accounts;

BEGIN

    AccountOperations.OpenAccount(
        101,
        1,
        'Savings',
        5000
    );

    DBMS_OUTPUT.PUT_LINE(
        'Total Balance = ' ||
        AccountOperations.GetTotalBalance(1)
    );

    AccountOperations.CloseAccount(101);

    COMMIT;

END;
/

SELECT * FROM Accounts;