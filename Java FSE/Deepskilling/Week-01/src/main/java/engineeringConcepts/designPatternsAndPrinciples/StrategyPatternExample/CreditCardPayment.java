package engineeringConcepts.designPatternsAndPrinciples.StrategyPatternExample;

public class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;

    public CreditCardPayment(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit Card Payment...");
        System.out.println("$" + amount + " paid successfully using Card: ****-****-****-" 
                           + cardNumber.substring(cardNumber.length() - 4) + " [" + name + "]");
    }
}