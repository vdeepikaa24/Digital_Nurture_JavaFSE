-- 1. Create/Recreate Table
DROP TABLE AuditLog;
CREATE TABLE AuditLog (
    LogID NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    LogDate DATE DEFAULT SYSDATE,
    Action VARCHAR2(50)
);

-- 2. Create/Recreate Trigger
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON TRANSACTIONS
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (LogID, TransactionID, LogDate, Action)
    VALUES ((SELECT NVL(MAX(LogID), 0) + 1 FROM AuditLog), :NEW.TransactionID, SYSDATE, 'Transaction Inserted');
EXCEPTION
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20001, 'Trigger failed: ' || SQLERRM);
END;
/