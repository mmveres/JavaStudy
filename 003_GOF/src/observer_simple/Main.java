package observer_simple;

public class Main {
public static void main(String[] args) {
	WeatherData data = new WeatherData();
	CurrentConditionsDisplay currentConditionsDisplay= new CurrentConditionsDisplay(data);
	ForecastDisplay fcDisplay=new ForecastDisplay(data);
	StatisticDisplay stDisplay = new StatisticDisplay(data);
	
	for (int i = 0; i < 20; i++) {
		System.out.println("=========================== Cycle "+ i+ "==================================");
		data.setMeasurement((float)(Math.random()*25), 20.0f+(float)(Math.random()*35), 80.0f+(float)(Math.random()*45));
	}
}
}
