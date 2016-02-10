package observer.base;

import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;

import observer.gui.*;
import observer.model.*;


public class Main {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		WeatherForm mainForm = new WeatherForm(weatherData);
		

	}
}
