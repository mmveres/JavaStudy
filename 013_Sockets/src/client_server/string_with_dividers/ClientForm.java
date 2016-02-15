package client_server.string_with_dividers;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ClientForm {

	private JFrame frame;
	private JTextField tfVal01;
	private JTextField tfVal02;
	private JTextField tfRes;
	private Client client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientForm window = new ClientForm();
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
	public ClientForm() {
		initialize();
		try {
			client = new Client("localhost", 12345);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		tfVal01 = new JTextField();
		tfVal01.setBounds(42, 53, 114, 19);
		panel.add(tfVal01);
		tfVal01.setColumns(10);
		
		tfVal02 = new JTextField();
		tfVal02.setBounds(42, 84, 114, 19);
		panel.add(tfVal02);
		tfVal02.setColumns(10);
		
		tfRes = new JTextField();
		tfRes.setBounds(42, 222, 114, 19);
		panel.add(tfRes);
		tfRes.setColumns(10);
		
		JButton btAdd = new JButton("+");
		btAdd.setBounds(248, 81, 117, 25);
		panel.add(btAdd);
		btAdd.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(inputFieldsOK()){
					try {
						tfRes.setText(""+client.sum(Integer.parseInt(tfVal01.getText()), Integer.parseInt(tfVal02.getText())));
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}


		});
		
		JButton btSub = new JButton("-");
		btSub.setBounds(248, 118, 117, 25);
		panel.add(btSub);
		btSub.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tfRes.setText(""+client.sub(Integer.parseInt(tfVal01.getText()), Integer.parseInt(tfVal02.getText())));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btDiv = new JButton("/");
		btDiv.setBounds(248, 157, 117, 25);
		panel.add(btDiv);
		btDiv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tfRes.setText(""+client.divide(Integer.parseInt(tfVal01.getText()), Integer.parseInt(tfVal02.getText())));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btMult = new JButton("*");
		btMult.setBounds(248, 194, 117, 25);
		panel.add(btMult);
		btMult.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tfRes.setText(""+client.mult(Integer.parseInt(tfVal01.getText()), Integer.parseInt(tfVal02.getText())));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
	
	private boolean inputFieldsOK() {
		
		return true;
	}
}
