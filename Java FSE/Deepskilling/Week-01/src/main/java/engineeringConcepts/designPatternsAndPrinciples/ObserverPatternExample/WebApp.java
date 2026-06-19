// WebApp.java
package engineeringConcepts.designPatternsAndPrinciples.ObserverPatternExample;

public class WebApp implements Observer {
    private String domainName;

    public WebApp(String domainName) {
        this.domainName = domainName;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("[Web Dashboard Live Broadcast - " + domainName + "] Live Feed: " + stockSymbol + " ticker hit $" + price);
    }
}