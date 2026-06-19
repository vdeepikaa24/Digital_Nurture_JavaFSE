package engineeringConcepts.designPatternsAndPrinciples.ObserverPatternExample;

public interface Stock {
    void registerObserver(Observer o);
    void deregisterObserver(Observer o);
    void notifyObservers();
}