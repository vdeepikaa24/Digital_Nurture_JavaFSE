# Scenario 2: Calculate Monthly Installment

## Description
This function calculates the Equated Monthly Installment (EMI) for a loan based on the principal amount, annual interest rate, and the duration in years.

## Function Details
- **Function Name:** `CalculateMonthlyInstallment`
- **Parameters:**
  - `p_amount` (NUMBER): Principal loan amount.
  - `p_annual_rate` (NUMBER): Annual interest rate (as a percentage).
  - `p_years` (NUMBER): Loan duration in years.
- **Logic:** Implements the standard amortization formula: 
  $M = P \times \frac{r(1+r)^n}{(1+r)^n - 1}$
- **Return Type:** NUMBER (Rounded to 2 decimal places).

## Verification
1. **Initial:** Query the `Loans` table to retrieve loan details.
2. **Execution:** Call `CalculateMonthlyInstallment` using the retrieved values.
3. **Result:** View the resulting monthly payment amount.