package DesignPatterns.ObserverPattern.WhetherStation;

public interface Observable {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
