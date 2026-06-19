// Main.java
package engineeringConcepts.designPatternsAndPrinciples.ObserverPatternExample;

public class Main {
    public static void main(String[] args) {
        // Create the core Stock Market feed
        StockMarket nasdaq = new StockMarket();

        // Create different client observers
        Observer iphoneApp = new MobileApp("iPhone Trader");
        Observer androidApp = new MobileApp("Android Portfolio");
        Observer webDashboard = new WebApp("finance.hub.com");

        System.out.println("=== 1. Registering Observers ===");
        nasdaq.registerObserver(iphoneApp);
        nasdaq.registerObserver(androidApp);
        nasdaq.registerObserver(webDashboard);

        System.out.println("\n=== 2. First Price Update (All devices notified) ===");
        nasdaq.setStockPrice("AAPL", 175.50);

        System.out.println("\n=== 3. Second Price Update ===");
        nasdaq.setStockPrice("TSLA", 240.25);

        System.out.println("\n=== 4. Deregistering Android App ===");
        nasdaq.deregisterObserver(androidApp);

        System.out.println("\n=== 5. Third Price Update (Android should not get this) ===");
        nasdaq.setStockPrice("AMZN", 130.10);
    }
}