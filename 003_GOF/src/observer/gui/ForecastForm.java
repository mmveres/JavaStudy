package observer.gui;

import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import observer.model.CurrentConditionsDisplay;
import observer.model.ForecastDisplay;
import observer.model.WeatherData;
import observer.model.WeatherGenerator;

public class ForecastForm extends JFrame {
	private JPanel cPanel = new JPanel();
	private JLabel labTempMarker = new JLabel("Temp");
	private JLabel labHumMarker = new JLabel("Humidity");
	private JLabel labPressMarker = new JLabel("Presure");
	private JTextField txtTemp = new JTextField(25);
	private JTextField txtHum = new JTextField(25);
	private JTextField txtPress = new JTextField(25);
	private JButton btnSubscribe = new JButton("Subscribe");
	private JButton btnUnsubscribe = new JButton("Unsubscribe");
	private ForecastDisplay forecastDisplay;

	public ForecastForm(final ForecastDisplay forecastDisplay) {
		this.forecastDisplay=forecastDisplay;
		cPanel.setBorder(new TitledBorder("Forecast"));
		cPanel.setLayout(new GridLayout(4, 2));
		cPanel.add(labTempMarker);
		cPanel.add(txtTemp);
		txtTemp.setEditable(false);
		cPanel.add(labHumMarker);
		cPanel.add(txtHum);
		txtHum.setEditable(false);
		cPanel.add(labPressMarker);
		cPanel.add(txtPress);
		txtPress.setEditable(false);
		cPanel.add(btnSubscribe);	
		btnSubscribe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				forecastDisplay.subscribe();
				
			}
		});
		cPanel.add(btnUnsubscribe);
		btnUnsubscribe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				forecastDisplay.unsubscribe();
				
			}
		});
		add(cPanel);
		setTitle(getClass().getSimpleName());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);

	}

public void setIndicators(String tempFC,String  humFC,String presFC){
	txtTemp.setText(tempFC);
	txtHum.setText(humFC);
	txtPress.setText(presFC);
}



}
