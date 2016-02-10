package observer_simple;

public class ForecastDisplay implements Observer, DisplayElement {
	private float temp, humidity, pressure;
	private float temp_prev, humidity_prev, pressure_prev;
	String tempFC, pressFC, humFC;
	
	private Subject weatherData;

	public ForecastDisplay(Subject weatherData) {
			this.weatherData = weatherData;
			weatherData.registerObserver(this);
		}

	@Override
	public void display() {
		System.out.println(tempFC
				);
		System.out.println(pressFC);

	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		updateForecast();
		display();

	}

	private void updateForecast() {
		if (temp_prev<temp){tempFC="Temperature will grow";}
		if (temp_prev>temp){tempFC="Temperature will fall";}
		if (temp_prev==temp){tempFC="Temperature will be stable";}
		temp_prev=temp;
		if (pressure>pressure_prev){pressFC="Stable and clear weather";}
		if (pressure<pressure_prev){pressFC="Rain possible";}
		if (pressure==pressure_prev){pressFC="No changes to forecast";}
		pressure_prev=pressure;
	}
}
