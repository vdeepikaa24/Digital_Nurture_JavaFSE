CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_amount IN NUMBER, 
    p_annual_rate IN NUMBER, 
    p_years IN NUMBER
) RETURN NUMBER AS
    v_monthly_rate NUMBER := (p_annual_rate / 100) / 12;
    v_months       NUMBER := p_years * 12;
    v_installment  NUMBER;
BEGIN
    -- Formula: M = P * (r(1+r)^n) / ((1+r)^n - 1)
    IF v_monthly_rate = 0 THEN
        RETURN ROUND(p_amount / v_months, 2);
    END IF;

    v_installment := p_amount * (v_monthly_rate * POWER(1 + v_monthly_rate, v_months)) / 
                     (POWER(1 + v_monthly_rate, v_months) - 1);
                     
    RETURN ROUND(v_installment, 2);
END;
/