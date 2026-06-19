-- If you need output, ensure your SQL tool settings have "DBMS Output" enabled
-- 1. Check data
SELECT * FROM ACCOUNTS;

-- 2. Test
EXEC SafeTransferFunds(1, 2, 1000);

-- 3. Verify
SELECT * FROM ACCOUNTS;