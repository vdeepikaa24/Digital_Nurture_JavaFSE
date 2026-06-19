package engineeringConcepts.designPatternsAndPrinciples.DecoratorPatternExample;

public class Main {
    public static void main(String[] args){
        String alertMessage = "System alert: Server load is high!";

        System.out.println("=== Test 1: Base Component Only ===");
        Notifier onlyEmail = new EmailNotifier();
        onlyEmail.send(alertMessage);

        System.out.println("\n=== Test 2: Email + SMS ===");
        Notifier emailAndSMS = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSMS.send(alertMessage);

        System.out.println("\n=== Test 3: Email + SMS + Slack ===");
        //Dynamically stacking all three channels together
        Notifier allChannels = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        allChannels.send(alertMessage);
    }
}
