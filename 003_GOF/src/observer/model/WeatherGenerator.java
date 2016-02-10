package observer.model;

import java.util.concurrent.TimeUnit;

public class WeatherGenerator implements Runnable {
	private boolean isActive = true;
	public static final float MIN_TEMP = -20;
	public static final float MAX_TEMP = 40;
	public static final float MIN_PRESS = 90;
	public static final float MAX_PRESS = 110;
	public static final float MIN_HUMIDITY = 20;
	public static final float MAX_HUMIDITY = 100;
	public static final int SLEEP_TIMEOUT=400;
	private float temp, humidity, pressure;
	private WeatherData weatherData;

	public WeatherGenerator() {
		// TODO Auto-generated constructor stub
	}

	public WeatherGenerator(WeatherData weatherData) {
		this.weatherData = weatherData;
	}

	@Override
	public void run() {
		while (isActive) {
			temp = MIN_TEMP + (float) (Math.random() * (MAX_TEMP - MIN_TEMP));
			humidity = MIN_HUMIDITY + ((float) (Math.random() * (MAX_HUMIDITY - MIN_HUMIDITY)));
			pressure = MIN_PRESS + ((float) (Math.random() * (MAX_PRESS - MIN_PRESS)));
			if (weatherData != null) {
				weatherData.setMeasurement(temp, humidity, pressure);
			}
			try {
				TimeUnit.MILLISECONDS.sleep(SLEEP_TIMEOUT);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
