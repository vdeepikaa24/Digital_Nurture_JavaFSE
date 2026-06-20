# Scenario 1: Calculate Customer Age

## Description
This function calculates the current age of a customer based on their Date of Birth (DOB). It is designed for use in eligibility checks (e.g., determining if a customer qualifies for a specific loan or account type).

## Function Details
- **Function Name:** `CalculateAge`
- **Input Parameter:** `p_dob` (DATE)
- **Logic:** - Utilizes the `MONTHS_BETWEEN` function to calculate the number of months between `SYSDATE` and the provided DOB.
  - Divides by 12 and uses `FLOOR` to round down to the nearest whole year.
- **Return Type:** NUMBER (Age in years)

## How to execute
To verify the age calculation, run the following SQL query:

```sql
SELECT 
    Name, 
    DOB, 
    CalculateAge(DOB) AS CURRENT_AGE 
FROM Customers;