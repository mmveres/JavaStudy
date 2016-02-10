package observer.model;

import java.util.Observable;
import java.util.Observer;

import observer.gui.StatistcsForm;



public class StatisticsDisplay implements Observer, DisplayElement {
	private float temp, humidity, pressure;
	private float tempMin, humidityMin, pressureMin;
	private float tempMax, humidityMax, pressureMax;
	private float tempAvg, humidityAvg, pressureAvg;
	private int counter;
	private int cycler;
	private float[] tempHistory = new float[10];
	private float[] humidityHistory = new float[10];
	private float[] pressureHistory = new float[10];
	private Observable observable;
	private StatistcsForm statistcsForm;
	private float []values=new float[9];
	
	public void setStatistcsForm(StatistcsForm statistcsForm) {
		this.statistcsForm = statistcsForm;
	}

	public StatisticsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
		for (int i = 0; i < tempHistory.length; i++) {
			tempHistory[i] = -500;
			tempMin = 500;
			tempMax = -500;
		}
	}

	@Override
	public void display() {
//		System.out.println("Temp min/max/average: " + tempMin + "/" + tempMax + "/" + tempAvg);
//		System.out.println("Humidity min/max/average: " + humidityMin + "/" + humidityMax + "/" + humidityAvg);
//		System.out.println("Pressure min/max/average: " + pressureMin + "/" + pressureMax + "/" + pressureAvg);
		if(statistcsForm!=null){
			values[0]=tempMin;
			values[1]=tempMax;
			values[2]=tempAvg;
			values[3]=humidityMin;
			values[4]=humidityMax;
			values[5]=humidityAvg;
			values[6]=pressureMin;
			values[7]=pressureMax;
			values[8]=pressureAvg;
			statistcsForm.setIndicators(values);
			
			
		}

	}

	private void validate() {
		if (tempMin == 0) {
			tempMin = temp;
		}
		if (temp < tempMin) {
			tempMin = temp;
		}
		if (temp > tempMax) {
			tempMax = temp;
		}
		if (humidityMin == 0) {
			humidityMin = humidity;
		}
		if (humidity > humidityMax) {
			humidityMax = humidity;
		}
		if (humidity < humidityMin) {
			humidityMin = humidity;
		}
		if (pressureMin == 0) {
			pressureMin = pressure;
		}
		if (pressure > pressureMax) {
			pressureMax = pressure;
		}
		if (pressure < pressureMin) {
			pressureMin = pressure;
		}
		if (counter < 10) {
			tempHistory[counter] = temp;
			humidityHistory[counter] = humidity;
			pressureHistory[counter] = pressure;
		} else {
			counter = 0;
			tempHistory[counter] = temp;
			humidityHistory[counter] = humidity;
			pressureHistory[counter] = pressure;
		}
		counter++;
		humidityAvg = 0;
		pressureAvg = 0;
		tempAvg = 0;
		cycler=0;
		while (cycler < humidityHistory.length) {

			if (humidityHistory[cycler] != 0) {
				humidityAvg += humidityHistory[cycler++];
			} else {
				break;
			}

		}

		humidityAvg = humidityAvg / (cycler + 1);
		cycler = 0;

		while (cycler < tempHistory.length) {
			if (tempHistory[cycler] != -500) {
				tempAvg += tempHistory[cycler++];

			} else {
				break;
			}
		}
		tempAvg = tempAvg / (cycler + 1);
		cycler = 0;

		while (cycler < pressureHistory.length) {

			if (pressureHistory[cycler] != 0) {
				pressureAvg += pressureHistory[cycler++];
			} else {
				break;
			}

		}
		pressureAvg = pressureAvg / (cycler + 1);

	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			this.temp = weatherData.getTemp();
			this.humidity = weatherData.getHumidity();
			this.pressure = weatherData.getPressure();
			validate();
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
