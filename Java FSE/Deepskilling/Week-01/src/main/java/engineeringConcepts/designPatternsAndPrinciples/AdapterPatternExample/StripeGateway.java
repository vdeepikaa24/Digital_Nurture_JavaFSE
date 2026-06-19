package engineeringConcepts.designPatternsAndPrinciples.AdapterPatternExample;

public class StripeGateway {
    public void chargeCustomer(double totalAmount){
        System.out.println("Charging credit card for amount: $" + totalAmount + " via Stripe API.");
    }
}
