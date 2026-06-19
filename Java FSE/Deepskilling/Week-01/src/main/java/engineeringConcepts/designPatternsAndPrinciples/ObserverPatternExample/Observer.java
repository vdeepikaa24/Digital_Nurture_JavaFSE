// Observer.java
package engineeringConcepts.designPatternsAndPrinciples.ObserverPatternExample;

public interface Observer {
    void update(String stockSymbol, double price);
}