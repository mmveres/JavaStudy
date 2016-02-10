package observer.model;

import java.util.Observable;
import java.util.Observer;

import observer.gui.CurrentConditionsForm;


public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temp, humidity, pressure;
	private Observable observable;
	CurrentConditionsForm currentConditionsForm;

	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}
	
	public void setCurrentConditionsGUI(CurrentConditionsForm currentConditionsGUI) {
		this.currentConditionsForm = currentConditionsGUI;
	}
	
	@Override
	public void display() {
//		System.out.println(
//				"Current conditions: " + temp + " C degrees and " + humidity + "% and pressure " + pressure + " kPa");
		if(currentConditionsForm!=null){
			currentConditionsForm.setIndicators(temp, humidity, pressure);
		}
		

	}

	public void unsubscribe(){
		observable.deleteObserver(this);
	}
	
	public void subscribe(){
		observable.addObserver(this);
	}
	

	@Override
	public void update(Observable o, Object arg) {
		
		if (o instanceof WeatherData){
			WeatherData weatherData = (WeatherData)o;
			this.temp = weatherData.getTemp();
			this.humidity = weatherData.getHumidity();
			this.pressure = weatherData.getPressure();
			display();
			
		}
		
	}

}
