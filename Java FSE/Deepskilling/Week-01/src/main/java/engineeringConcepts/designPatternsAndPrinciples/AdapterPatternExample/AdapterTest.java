package engineeringConcepts.designPatternsAndPrinciples.AdapterPatternExample;

public class AdapterTest {
    public static void main(String[] args){
        System.out.println("=== Third-Party Payment Integration (Adapter Pattern) ===\n");

        //1. Using PayPal through our unified adapter interface
        PayPalGateway payPalService = new PayPalGateway();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalService);
        System.out.println("--- Client triggers PayPal ---");
        payPalProcessor.processPayment(150.75);
        System.out.println();

        //2. Using Stripe through our unified adapter interface
        StripeGateway stripeService = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeService);
        System.out.println("--- Client triggers Stripe ---");
        stripeProcessor.processPayment(299.99);
    }
}
