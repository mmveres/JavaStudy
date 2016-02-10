package observer.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import observer.model.CurrentConditionsDisplay;
import observer.model.ForecastDisplay;
import observer.model.StatisticsDisplay;
import observer.model.WeatherData;
import observer.model.WeatherGenerator;

public class WeatherForm extends JFrame implements Observer {
	private JPanel cPanel = new JPanel();
	private JLabel labTempMarker = new JLabel("Temp, C");
	private JLabel labHumMarker = new JLabel("Humidity, %");
	private JLabel labPressMarker = new JLabel("Presure, KPa");
	private JLabel labTemp = new JLabel("0.0");
	private JLabel labHum = new JLabel("0.0");
	private JLabel labPress = new JLabel("0.0");
	private JToggleButton btnStartStop = new JToggleButton("Start");
	private JButton btnInformers = new JButton("Informers");
	private Observable observable;
	private WeatherGenerator weatherGenerator;
	private CurrentConditionsDisplay currentConditionsDisplay;
	private CurrentConditionsForm currentConditionsForm;
	private ForecastForm forecastForm;
	private ForecastDisplay forecastDisplay;
	private StatistcsForm statistcsForm;
	private StatisticsDisplay statisticsDisplay;

	private Thread generatorThread;

	public WeatherForm(final Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
		cPanel.setBorder(new TitledBorder("Weather data"));
		cPanel.setLayout(new GridLayout(4, 2));
		cPanel.add(labTempMarker);
		cPanel.add(labTemp);
		cPanel.add(labHumMarker);
		cPanel.add(labHum);
		cPanel.add(labPressMarker);
		cPanel.add(labPress);
		cPanel.add(btnStartStop);
		btnStartStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnStartStop.isSelected()) {
					btnStartStop.setText("Stop");
					startGeneration();

				} else {
					btnStartStop.setText("Start");
					stopGeneration();
				}

			}

			private void stopGeneration() {
				weatherGenerator.setActive(false);
				try {
					TimeUnit.MILLISECONDS.sleep(weatherGenerator.SLEEP_TIMEOUT + 1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				generatorThread.interrupt();

			}

			private void startGeneration() {
				weatherGenerator = new WeatherGenerator((WeatherData) observable);
				generatorThread = new Thread(weatherGenerator);
				generatorThread.start();

			}
		});
		cPanel.add(btnInformers);
		btnInformers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startCurrentConditionsInformer();
				startForecastInformer();
				startStatisticsInformer();

			}

			private void startStatisticsInformer() {
				if (statisticsDisplay == null) {
					statisticsDisplay = new StatisticsDisplay((WeatherData) observable);
				}
				if (statistcsForm == null) {
					statistcsForm = new StatistcsForm(statisticsDisplay);
				}
				statisticsDisplay.setStatistcsForm(statistcsForm);
			}

			private void startForecastInformer() {
				if (forecastDisplay == null) {
					forecastDisplay = new ForecastDisplay((WeatherData) observable);
				}
				if (forecastForm == null) {
					forecastForm = new ForecastForm(forecastDisplay);
				}
				forecastDisplay.setForecastForm(forecastForm);

			}

			private void startCurrentConditionsInformer() {
				if (currentConditionsDisplay == null) {
					currentConditionsDisplay = new CurrentConditionsDisplay((WeatherData) observable);
				}
				if (currentConditionsForm == null) {
					currentConditionsForm = new CurrentConditionsForm(currentConditionsDisplay);
				}
				currentConditionsDisplay.setCurrentConditionsGUI(currentConditionsForm);

			}
		});
		add(cPanel);
		setTitle(getClass().getSimpleName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			labTemp.setText(Float.toString(weatherData.getTemp()));
			labHum.setText(Float.toString(weatherData.getHumidity()));
			labPress.setText(Float.toString(weatherData.getPressure()));

		}

	}
}
