package engineeringConcepts.dataStructuresAndAlgorithms.FinancialForecasting;

public class FinancialForecaster {

    /**
     * 1. Baseline Recursive Approach
     * Calculates future value based on a constant compounding growth rate.
     * Formula: FV = PV * (1 + rate)^years
     * Time Complexity: O(n) where n is the number of years.
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base Case: If years is 0, the future value is exactly the present value
        if (years == 0) {
            return presentValue;
        }
        
        // Recursive Case: FV(t) = FV(t-1) * (1 + growthRate)
        return calculateFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    /**
     * 2. Optimized Recursive Approach (Fast Exponentiation / Divide & Conquer)
     * Reduces the number of recursive stack calls drastically.
     * Time Complexity: O(log n)
     */
    public static double calculateFutureValueOptimized(double presentValue, double growthRate, int years) {
        return presentValue * power((1 + growthRate), years);
    }

    // Helper method to compute power in O(log n) time recursively
    private static double power(double base, int exponent) {
        if (exponent == 0) return 1;
        
        double halfPower = power(base, exponent / 2);
        
        // If exponent is even: base^exp = base^(exp/2) * base^(exp/2)
        if (exponent % 2 == 0) {
            return halfPower * halfPower;
        } else {
            // If exponent is odd: base^exp = base * base^(exp/2) * base^(exp/2)
            return base * halfPower * halfPower;
        }
    }
}