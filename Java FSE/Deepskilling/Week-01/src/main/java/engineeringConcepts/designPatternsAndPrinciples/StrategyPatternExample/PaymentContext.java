// PaymentContext.java
package engineeringConcepts.designPatternsAndPrinciples.StrategyPatternExample;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Allows setting strategy via constructor
    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Allows swapping strategies dynamically at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        System.out.println("\n[Context] Swapping payment processing strategy...");
        this.paymentStrategy = paymentStrategy;
    }

    // Executes the strategy algorithm
    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Error: No payment strategy selected!");
            return;
        }
        paymentStrategy.pay(amount);
    }
}