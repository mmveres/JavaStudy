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
import observer.model.WeatherData;
import observer.model.WeatherGenerator;

public class CurrentConditionsForm extends JFrame {
	private JPanel cPanel = new JPanel();
	private JLabel labTempMarker = new JLabel("Temp, C");
	private JLabel labHumMarker = new JLabel("Humidity, %");
	private JLabel labPressMarker = new JLabel("Presure, KPa");
	private JLabel labTemp = new JLabel("0.0");
	private JLabel labHum = new JLabel("0.0");
	private JLabel labPress = new JLabel("0.0");
	private JButton btnSubscribe = new JButton("Subscribe");
	private JButton btnUnsubscribe = new JButton("Unsubscribe");
	private CurrentConditionsDisplay currentConditionsDisplay;

	public CurrentConditionsForm(final CurrentConditionsDisplay currentConditionsDisplay) {
		this.currentConditionsDisplay=currentConditionsDisplay;
		cPanel.setBorder(new TitledBorder("Current Conditions"));
		cPanel.setLayout(new GridLayout(4, 2));
		cPanel.add(labTempMarker);
		cPanel.add(labTemp);
		cPanel.add(labHumMarker);
		cPanel.add(labHum);
		cPanel.add(labPressMarker);
		cPanel.add(labPress);
		cPanel.add(btnSubscribe);	
		btnSubscribe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currentConditionsDisplay.subscribe();
				
			}
		});
		cPanel.add(btnUnsubscribe);
		btnUnsubscribe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currentConditionsDisplay.unsubscribe();
				
			}
		});
		add(cPanel);
		setTitle(getClass().getSimpleName());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);

	}

public void setIndicators(float temp,float  humidity,float pressure){
	labTemp.setText(Float.toString(temp));
	labHum.setText(Float.toString(humidity));
	labPress.setText(Float.toString(pressure));
}



}
