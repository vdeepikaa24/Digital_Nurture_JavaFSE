// PayPalPayment.java
package engineeringConcepts.designPatternsAndPrinciples.StrategyPatternExample;

public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Redirecting to PayPal Gateway...");
        System.out.println("$" + amount + " paid successfully via PayPal account: (" + email + ")");
    }
}