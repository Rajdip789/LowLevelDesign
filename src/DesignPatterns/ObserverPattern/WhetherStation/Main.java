package DesignPatterns.ObserverPattern.WhetherStation;

public class Main {
    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation();
        Observer o1 = new CurrentWeatherConditionDisplay(ws);
        Observer o2 = new AverageTemperatureDisplay(ws);

        ws.parametersChanged(6, 70);
        ws.parametersChanged(10, 60);
    }
}
