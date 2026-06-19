// Main.java
package engineeringConcepts.designPatternsAndPrinciples.StrategyPatternExample;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. Checking out Shopping Cart (Initial Strategy: Credit Card) ===");
        // Instantiate first strategy
        PaymentStrategy cardStrategy = new CreditCardPayment("Alice Smith", "1234567890123456");
        
        // Pass strategy into the context
        PaymentContext cart = new PaymentContext(cardStrategy);
        cart.executePayment(250.75);

        System.out.println("\n=== 2. New Transaction (Switching Strategy to PayPal) ===");
        // Instantiate a completely different strategy
        PaymentStrategy paypalStrategy = new PayPalPayment("alice.smith@example.com");
        
        // Dynamic swap on the same context engine instance
        cart.setPaymentStrategy(paypalStrategy);
        cart.executePayment(89.99);
    }
}