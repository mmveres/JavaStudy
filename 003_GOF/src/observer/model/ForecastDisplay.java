package observer.model;

import java.util.Observable;
import java.util.Observer;

import observer.gui.ForecastForm;


public class ForecastDisplay implements Observer, DisplayElement {
	private float temp, humidity, pressure;
	private float temp_prev, humidity_prev, pressure_prev;
	String tempFC, presFC, humFC;
	private Observable observable;
	private ForecastForm forecastForm;
	
	public void setForecastForm(ForecastForm forecastForm) {
		this.forecastForm = forecastForm;
	}
	
	public ForecastDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}


	@Override
	public void display() {
//		System.out.println(tempFC				);
//		System.out.println(presFC);
//		System.out.println(humFC);
		if(forecastForm!=null){
			forecastForm.setIndicators(tempFC, humFC, presFC);
		}
		

	}



	private void updateForecast() {
		if (temp_prev<temp){tempFC="Temperature will grow";}
		if (temp_prev>temp){tempFC="Temperature will fall";}
		if (temp_prev==temp){tempFC="Temperature will be stable";}
		temp_prev=temp;
		if (pressure>pressure_prev){presFC="Stable and clear weather expected";}
		if (pressure<pressure_prev){presFC="Precipitation possible";}
		if (pressure==pressure_prev){presFC="No changes to forecast";}
		pressure_prev=pressure;
		if(humidity>humidity_prev){humFC="Precipitation likely";}
		if(humidity<humidity_prev){humFC="Sky will clear";}
		if(humidity==humidity_prev){humFC="Stable weather";}
		humidity_prev=humidity;
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData){
			WeatherData weatherData = (WeatherData)o;
			this.temp = weatherData.getTemp();
			this.humidity = weatherData.getHumidity();
			this.pressure = weatherData.getPressure();
			updateForecast();
			display();
		}
		
	}
	
	public void unsubscribe(){
		observable.deleteObserver(this);
	}
	
	public void subscribe(){
		observable.addObserver(this);
	}
}
