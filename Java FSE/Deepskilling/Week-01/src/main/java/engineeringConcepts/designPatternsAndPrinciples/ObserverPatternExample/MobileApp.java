// MobileApp.java
package engineeringConcepts.designPatternsAndPrinciples.ObserverPatternExample;

public class MobileApp implements Observer {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("[Mobile Push Alert - " + appName + "] " + stockSymbol + " changed to $" + price);
    }
}