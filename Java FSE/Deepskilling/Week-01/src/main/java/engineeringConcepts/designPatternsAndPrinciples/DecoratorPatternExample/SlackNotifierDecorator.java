package engineeringConcepts.designPatternsAndPrinciples.DecoratorPatternExample;

public class SlackNotifierDecorator extends NotifierDecorator{
    public SlackNotifierDecorator(Notifier notifier){
        super(notifier);
    }

    @Override
    public void send(String message){
        super.send(message); //Sends the previous notification first
        sendSlackMessage(message); //Add the Slack behavior
    }

    private void sendSlackMessage(String message){
        System.out.println("Sending Slack Message: " + message);
    }
} 
