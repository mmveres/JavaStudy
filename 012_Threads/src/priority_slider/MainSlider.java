package priority_slider;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainSlider {

	private JFrame frame;
	private JTextField textFieldLPriority;
	private JTextField textFieldRPriority;
	JSlider slider;
	SliderThread threadL;
	SliderThread threadR;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainSlider window = new MainSlider();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainSlider() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		slider = new JSlider();
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(100);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBounds(72, 54, 298, 59);
		panel.add(slider);
		
		JButton buttonLPlus = new JButton("+");
		buttonLPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				threadL.setPriority(threadL.getPriority()+1);
				textFieldLPriority.setText(
						Integer.toString(threadL.getPriority()));
			}
		});
		buttonLPlus.setBounds(10, 126, 89, 23);
		panel.add(buttonLPlus);
		
		JButton buttonLMinus = new JButton("-");
		buttonLMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				threadL.setPriority(threadL.getPriority()-1);
				textFieldLPriority.setText(
						Integer.toString(threadL.getPriority()));
			}
		});
		buttonLMinus.setBounds(10, 150, 89, 23);
		panel.add(buttonLMinus);
		
		JButton buttonRPlus = new JButton("+");
		buttonRPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				threadR.setPriority(threadR.getPriority()+1);
				textFieldRPriority.setText(
						Integer.toString(threadR.getPriority()));
			}
		});
		buttonRPlus.setBounds(310, 124, 89, 23);
		panel.add(buttonRPlus);
		
		JButton buttonRMinus = new JButton("-");
		buttonRMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				threadR.setPriority(threadR.getPriority()-1);
				textFieldRPriority.setText(
						Integer.toString(threadR.getPriority()));
			}
		});
		buttonRMinus.setBounds(310, 150, 89, 23);
		panel.add(buttonRMinus);
		
		textFieldLPriority = new JTextField();
		textFieldLPriority.setBounds(13, 184, 86, 20);
		panel.add(textFieldLPriority);
		textFieldLPriority.setColumns(10);
		
		textFieldRPriority = new JTextField();
		textFieldRPriority.setBounds(313, 184, 86, 20);
		panel.add(textFieldRPriority);
		textFieldRPriority.setColumns(10);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				threadL= new SliderThread(slider, -1);
				threadR= new SliderThread(slider, +1);
				threadL.start();
				threadR.start();
				textFieldLPriority.setText(
						Integer.toString(threadL.getPriority()));
				textFieldRPriority.setText(
						Integer.toString(threadR.getPriority()));
			}
		});
		btnStart.setBounds(172, 11, 89, 23);
		panel.add(btnStart);
	}
}