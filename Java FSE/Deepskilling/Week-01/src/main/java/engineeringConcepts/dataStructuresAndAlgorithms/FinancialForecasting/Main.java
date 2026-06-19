package engineeringConcepts.dataStructuresAndAlgorithms.FinancialForecasting;

public class Main {
    public static void main(String[] args) {
        double initialInvestment = 10000.0; // $10,000 present value
        double annualGrowthRate = 0.07;     // 7% average annual market growth rate
        int forecastHorizon = 10;           // Predict 10 years out

        System.out.println("=== 📈 Running Financial Forecasting Tool ===");
        System.out.println("Initial Investment: $" + initialInvestment);
        System.out.println("Assumed Growth Rate: " + (annualGrowthRate * 100) + "%");
        System.out.println("Horizon: " + forecastHorizon + " Years\n");

        // Execute standard linear recursion
        double futureValueBase = FinancialForecaster.calculateFutureValue(initialInvestment, annualGrowthRate, forecastHorizon);
        System.out.printf("Predicted Value (Standard Recursion): $%.2f\n", futureValueBase);

        // Execute optimized logarithmic recursion
        double futureValueOpt = FinancialForecaster.calculateFutureValueOptimized(initialInvestment, annualGrowthRate, forecastHorizon);
        System.out.printf("Predicted Value (Optimized O(log n)): $%.2f\n", futureValueOpt);
    }
}