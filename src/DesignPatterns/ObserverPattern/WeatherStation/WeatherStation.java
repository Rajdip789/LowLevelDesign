package DesignPatterns.ObserverPattern.WeatherStation;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Observable {

    private List<Observer> observers;
    private int temperature;
    private int humidity;

    public WeatherStation() {
        this.observers = new ArrayList<>();
    }

    private boolean hasObserver(Observer observer) {
        int index = observers.indexOf(observer);
        return index >= 0;
    }

    public void registerObserver(Observer observer) {
        if(!hasObserver(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(Observer observer) {
        if(hasObserver(observer)) {
            observers.remove(observers.indexOf(observer));
        }
    }

    public void notifyObservers() {
        observers.forEach(observer -> observer.update(temperature, humidity));
    }

    public void parametersChanged(int temperature, int humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }
}
