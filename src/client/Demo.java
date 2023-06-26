package client;

import java.util.ArrayList;

import weather.WeatherStation;
import weather.CurrentConditionsDisplay;
import weather.Display;
import weather.RainChanceDisplay;
import weather.StatisticsDisplay;

public class Demo {
    public static void main(String[] args) {
        System.out.print("\n\n\n");
        WeatherStation myStation = new WeatherStation();
        ArrayList<Display> displays = new ArrayList<>();
        displays.add(new CurrentConditionsDisplay(myStation));
        displays.add(new StatisticsDisplay(myStation));
        displays.add(new RainChanceDisplay(myStation));

        myStation.updateReadings();
        System.out.print("\n\n\n");
    }
}
