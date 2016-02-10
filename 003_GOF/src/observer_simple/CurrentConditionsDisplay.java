package observer_simple;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temp, humidity, pressure;
	private Subject weatherData;

	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println(
				"Current conditions: " + temp + " C degrees and " + humidity + "% and pressure " + pressure + " Pa");

	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();

	}

}
