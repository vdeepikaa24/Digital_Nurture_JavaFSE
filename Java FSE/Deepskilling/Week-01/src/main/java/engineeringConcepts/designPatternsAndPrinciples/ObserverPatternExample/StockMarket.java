// StockMarket.java
package engineeringConcepts.designPatternsAndPrinciples.ObserverPatternExample;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockSymbol;
    private double price;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
        System.out.println("[StockMarket] Registered a new device/app.");
    }

    @Override
    public void deregisterObserver(Observer o) {
        observers.remove(o);
        System.out.println("[StockMarket] Deregistered an app.");
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockSymbol, price);
        }
    }

    // Business logic method to update prices
    public void setStockPrice(String stockSymbol, double price) {
        this.stockSymbol = stockSymbol;
        this.price = price;
        System.out.println("\n--- Stock Update: " + stockSymbol + " is now $" + price + " ---");
        notifyObservers(); // Automatically alert everyone!
    }
}