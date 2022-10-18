package weather;

public class StatisticsDisplay implements Observer, Display {
	private double maxTemp = 0.0f;
	private double minTemp = 200;
	private double tempSum= 0.0f;
	private int numReadings = 1;
    
	public StatisticsDisplay(WeatherStation dataSource) {
	    dataSource.registerObserver(this);
    }

    @Override
	public void update(Subject o, Object args) {
        WeatherStation data = (WeatherStation) o;
        double temp = data.getTemp();
		tempSum += temp;
		if (temp > maxTemp) maxTemp = temp;
		if (temp < minTemp) minTemp = temp;
		display();
		numReadings++;
	}

	public void display() {
		System.out.printf("Avg/Max/Min temperature = %.2f/%.2f/%.2f\n",
			(tempSum / numReadings), maxTemp, minTemp);
	}
}
