package engineeringConcepts.designPatternsAndPrinciples.AdapterPatternExample;

public class PayPalAdapter implements PaymentProcessor{
    private PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway){
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount){
        //Translates target method processPayment() to adaptee method makePayment()
        payPalGateway.makePayment(amount);
    }
    
}
