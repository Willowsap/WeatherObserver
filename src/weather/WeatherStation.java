package weather;
import java.util.ArrayList;
public class WeatherStation implements Subject, WeatherData {

    // List of observers needed for StationObservable
    private ArrayList<Observer> observers;

    // fields needed for WeatherData and WeatherReceiver
    private double temp, humidity, rainChance;

    public WeatherStation() {
        this.observers = new ArrayList<>();
        updateReadings();
    }

    // Weather Calculators
    public void updateReadings() {
        this.temp = Math.random() * 60 + 30;
        this.humidity = Math.random() * 100;
        this.rainChance = Math.random() * 100;
        notifyAllObservers();
    }

    // StationObservable Methods
    @Override
    public void registerObserver(Observer o) { observers.add(o); }
    @Override
    public void removeObserver(Observer o) { observers.remove(o); }
    @Override
    public void notifyObserver(Observer o) { o.update(this, null); }
    @Override
    public void notifyAllObservers() { for (Observer o : observers) o.update(this, null); }

    // WeatherData Methods
    @Override
    public double getTemp() { return this.temp; }
    @Override
    public double getHumidity() { return this.humidity; }
    @Override
    public double getRainChance() { return this.rainChance; }
}
