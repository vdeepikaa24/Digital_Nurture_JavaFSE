SET SERVEROUTPUT ON;

DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT
            c.CustomerID,
            c.Name,
            t.TransactionID,
            t.TransactionDate,
            t.TransactionType,
            t.Amount
        FROM Customers c
        JOIN Accounts a
            ON c.CustomerID = a.CustomerID
        JOIN Transactions t
            ON a.AccountID = t.AccountID
        WHERE TO_CHAR(t.TransactionDate, 'MMYYYY') =
              TO_CHAR(SYSDATE, 'MMYYYY')
        ORDER BY c.CustomerID, t.TransactionDate;

    v_CustomerID      Customers.CustomerID%TYPE;
    v_Name            Customers.Name%TYPE;
    v_TransactionID   Transactions.TransactionID%TYPE;
    v_TransactionDate Transactions.TransactionDate%TYPE;
    v_TransactionType Transactions.TransactionType%TYPE;
    v_Amount          Transactions.Amount%TYPE;

BEGIN
    DBMS_OUTPUT.PUT_LINE('MONTHLY CUSTOMER STATEMENTS');
    DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------');

    OPEN GenerateMonthlyStatements;

    LOOP
        FETCH GenerateMonthlyStatements
        INTO v_CustomerID,
             v_Name,
             v_TransactionID,
             v_TransactionDate,
             v_TransactionType,
             v_Amount;

        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Customer ID: ' || v_CustomerID ||
            ', Name: ' || v_Name ||
            ', Transaction ID: ' || v_TransactionID ||
            ', Date: ' || TO_CHAR(v_TransactionDate, 'DD-MON-YYYY') ||
            ', Type: ' || v_TransactionType ||
            ', Amount: ' || v_Amount
        );
    END LOOP;

    CLOSE GenerateMonthlyStatements;
END;
/