package weather;

public class RainChanceDisplay implements Observer, Display {
    
    private double currentRainChance = -1;
    private double lastRainChance = -1;

    public RainChanceDisplay(WeatherStation dataSource) {
        dataSource.registerObserver(this);    
    }

    @Override
    public void update(Subject o, Object args) {
        WeatherStation data = (WeatherStation) o;
	    lastRainChance = currentRainChance;
	    currentRainChance = data.getRainChance();
	    display();
    }

    public void display() {
	    System.out.printf("Forecast: %s",
            lastRainChance < currentRainChance
                ? "Chance of rain has increased to %.2f%s\n"
            : lastRainChance > currentRainChance
                ? "Chance of rain has decreased to %.2f%s\n"
            : lastRainChance == currentRainChance
	            ? "Chance or rain remasings at %.2f%s\n"
            : "ERROR\n", currentRainChance, "%");
	}
}

