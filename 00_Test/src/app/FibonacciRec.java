package app;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class FibonacciRec {
	private long result;
	private JLabel lblN;
	private JLabel lblFib;
	private boolean active;
	private JButton btnStart;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FibonacciRec window = new FibonacciRec();
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
	public FibonacciRec() {
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
		
		lblN = new JLabel("New label");
		lblN.setBounds(70, 100, 70, 15);
		panel.add(lblN);
		
		lblFib = new JLabel("New label");
		lblFib.setBounds(70, 130, 334, 15);
		panel.add(lblFib);
		
		btnStart = new JButton("Start");
		btnStart.setBounds(40, 213, 117, 25);
		panel.add(btnStart);
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(active){
					active=false;
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					btnStart.setText("Start");
				}else{
					btnStart.setText("Stop");
					active=true;
					new Thread(new Runnable() {
						
						@Override
						public void run() {
							int count=0;
							while(active){
								if(count>500_000)count=0;
								setN(count);
								setValue(getFibonnaci(count));
								count++;
							}
							
						}



						
					}).start();
				}
				
				
				
			}
		});
	}
	
	private Long getFibonnaci(int n){
		if(!active)return 0L;
		if(n<3)return 1L;
		return getFibonnaci(n-2)+getFibonnaci(n-1);
	}
	
	private void setN(final int count) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				lblN.setText(""+count);
				
			}
		});
		
	}
	
	private void setValue(final Long fibonnaci) {
EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				lblFib.setText(""+fibonnaci);
				
			}
		});
		
	}
}
