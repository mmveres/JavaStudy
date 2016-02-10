package observer.model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

public class WeatherData extends Observable {
	private float temp, humidity, pressure;
	private boolean genEnabled = false;
	
	
	

	public WeatherData() {

	}

	public void measurementChanged() {
		setChanged();
		notifyObservers();
	}

	public void setMeasurement(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementChanged();
	}


	public float getTemp() {
		return temp;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

}
