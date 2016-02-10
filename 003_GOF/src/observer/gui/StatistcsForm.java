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

public class StatistcsForm extends JFrame {
	private JPanel cPanel = new JPanel();
	
	private JLabel labValue = new JLabel("Value");
	private JLabel labValueMin = new JLabel("Min");
	private JLabel labValueMax = new JLabel("Max");
	private JLabel labValueAvg = new JLabel("Avg");
	private JLabel labTempMarker = new JLabel("Temp, C");
	private JLabel labHumMarker = new JLabel("Humidity, %");
	private JLabel labPressMarker = new JLabel("Presure, KPa");
	private JLabel []labVal=new JLabel[9];

	private JButton btnSubscribe = new JButton("Subscribe");
	private JButton btnUnsubscribe = new JButton("Unsubscribe");
	private StatisticsDisplay statisticDisplay;

	public StatistcsForm(final StatisticsDisplay statisticDisplay) {
		this.statisticDisplay=statisticDisplay;
		cPanel.setBorder(new TitledBorder("Weather Statistics"));
		cPanel.setLayout(new GridLayout(5, 4));
		cPanel.add(labValue);
		cPanel.add(labValueMin);
		cPanel.add(labValueMax);
		cPanel.add(labValueAvg);
		cPanel.add(labTempMarker);
		cPanel.add(labVal[0]=new JLabel("0.0"));
		cPanel.add(labVal[1]=new JLabel("0.0"));
		cPanel.add(labVal[2]=new JLabel("0.0"));
		cPanel.add(labHumMarker);
		cPanel.add(labVal[3]=new JLabel("0.0"));
		cPanel.add(labVal[4]=new JLabel("0.0"));
		cPanel.add(labVal[5]=new JLabel("0.0"));
		cPanel.add(labPressMarker);
		cPanel.add(labVal[6]=new JLabel("0.0"));
		cPanel.add(labVal[7]=new JLabel("0.0"));
		cPanel.add(labVal[8]=new JLabel("0.0"));
		cPanel.add(btnSubscribe);	
		btnSubscribe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				statisticDisplay.subscribe();
				
			}
		});
		cPanel.add(btnUnsubscribe);
		btnUnsubscribe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				statisticDisplay.unsubscribe();
				
			}
		});
		add(cPanel);
		setTitle(getClass().getSimpleName());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);

	}

public void setIndicators(float []values){
	for (int i = 0; i < values.length; i++) {
		labVal[i].setText(Float.toString(values[i]));
	}
}



}
