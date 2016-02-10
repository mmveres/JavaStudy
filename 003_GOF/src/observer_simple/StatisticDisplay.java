package observer_simple;

public class StatisticDisplay implements Observer, DisplayElement {
	private float temp, humidity, pressure;
	private Subject weatherData;
	private float tempMin, humidityMin, pressureMin;
	private float tempMax, humidityMax, pressureMax;
	private float tempAvg, humidityAvg, pressureAvg;
	private int counter;
	private float []tempHistory= new float[10];
	private float []humidityHistory= new float[10];
	private float []pressureHistory= new float[10];


	public StatisticDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println(
				"Temp min/max/average: " + tempMin + "/" + tempMax + "/" + tempAvg);
		System.out.println(
				"Humidity min/max/average: " + humidityMin + "/" + humidityMax + "/" + humidityAvg);
		System.out.println(
						"Pressure min/max/average: " + pressureMin + "/" + pressureMax + "/" + pressureAvg);

	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		validate();
		display();

	}

	private void validate() {
		if(tempMin==0){tempMin=temp;}
		if(temp<tempMin){tempMin=temp;}
		if(temp>tempMax){tempMax=temp;}
		if(humidityMin==0){humidityMin=humidity;}
		if(humidity>humidityMax){humidityMax=humidity;}
		if(humidity<humidityMin){humidityMin=humidity;}
		if(pressureMin==0){pressureMin=pressure;}
		if(pressure>pressureMax){pressureMax=pressure;}
		if(pressure<pressureMin){pressureMin=pressure;}
		if(counter<10){
			tempHistory[counter]=temp;
			humidityHistory[counter]=humidity;
			pressureHistory[counter]=pressure;
		}else{
			counter=0;
			tempHistory[counter]=temp;
			humidityHistory[counter]=humidity;
			pressureHistory[counter]=pressure;
		}
		counter++;
		humidityAvg=0;
		pressureAvg=0;
		tempAvg=0;
		for (int i = 0; i < humidityHistory.length; i++) {
			humidityAvg+=humidityHistory[i];
		}
		humidityAvg=humidityAvg/10;
		
		for (int i = 0; i < pressureHistory.length; i++) {
			pressureAvg+=pressureHistory[i];
		}
		pressureAvg=pressureAvg/10;
		
		for (int i = 0; i < tempHistory.length; i++) {
			tempAvg+=tempHistory[i];
		}
		tempAvg=tempAvg/10;
	}

}
