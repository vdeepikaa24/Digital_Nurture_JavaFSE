package engineeringConcepts.designPatternsAndPrinciples.AdapterPatternExample;

public class StripeAdapter implements PaymentProcessor{
    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway){
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment (double amount){
        //Translates target method processPayment() to adaptee method chargeCustomer()
        stripeGateway.chargeCustomer(amount);
    }
}
