SELECT 'INITIAL' as STATUS, Name, DOB 
FROM Customers;
SELECT 
    'EXECUTION' as STATUS, 
    Name, 
    DOB, 
    CalculateAge(DOB) AS CALCULATED_AGE 
FROM Customers;