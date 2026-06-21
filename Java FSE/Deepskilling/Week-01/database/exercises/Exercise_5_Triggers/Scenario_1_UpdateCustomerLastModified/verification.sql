--- INITIAL STATUS ---
SELECT CustomerID, Name, LastModified 
FROM CUSTOMERS 
WHERE CustomerID = 1;

-- Perform the update to fire the trigger
UPDATE CUSTOMERS 
SET Balance = Balance + 100 
WHERE CustomerID = 1;

COMMIT;

--- FINAL STATUS (After Update) ---
SELECT CustomerID, Name, LastModified 
FROM CUSTOMERS 
WHERE CustomerID = 1;