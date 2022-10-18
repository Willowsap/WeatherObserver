package weather;

public class CurrentConditionsDisplay implements Observer, Display {
	private double temperature;
	private double humidity;
	
    public CurrentConditionsDisplay(WeatherStation dataSource) {
	    dataSource.registerObserver(this);
    }
	
    @Override
	public void update(Subject o, Object arg) {
		WeatherStation data = (WeatherStation) o;
        this.temperature = data.getTemp();
		this.humidity = data.getHumidity();
		display();
	}

	public void display() {
		System.out.printf("Current conditions: %.2f F degrees and %.2f%s humidity\n",
            temperature, humidity, "%");
	}
}
