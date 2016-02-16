package jabber.clientGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import jabber.client.JabberClient;
import jabber.client.JabberClientListener;
import jabber.entities.User;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginGUI implements JabberClientListener {

	private JFrame frame;
	private JTextField tfLogin;
	private JPasswordField passwordField;
	private LoginGUI loginGUI;
	private JLabel lblStatus;
	private boolean shutdown;
	private JabberClient jabberClient;
	private JButton btnLogin;
	private JButton btnCancel;
	private JButton btnRegister;
	

	public JabberClient getJabberClient() {
		return jabberClient;
	}

	public void setJabberClient(JabberClient jabberClient) {
		this.jabberClient = jabberClient;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
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
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		lblStatus = new JLabel("");
		lblStatus.setBounds(20, 250, 430, 15);
		panel.add(lblStatus);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(20, 50, 70, 15);
		panel.add(lblLogin);

		JLabel lblPwd = new JLabel("Password");
		lblPwd.setBounds(20, 100, 70, 15);
		panel.add(lblPwd);

		tfLogin = new JTextField();
		tfLogin.setBounds(150, 50, 150, 20);
		tfLogin.setEnabled(false);
		panel.add(tfLogin);
		tfLogin.setColumns(10);

		btnLogin = new JButton("Login");
		btnLogin.setEnabled(false);
		btnLogin.setBounds(20, 198, 117, 25);
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String login = tfLogin.getText();
				int pwd = 0;
				if (login.equals("")) {
					setStatusLine("Enter valid login!!!!");
				} else if (passwordField.getPassword().length < 1) {
					setStatusLine("Enter correct password!");
				} else {
					pwd = (new String(passwordField.getPassword())).hashCode();
					jabberClient.doLogin(login, pwd);
				}
			}
		});
		panel.add(btnLogin);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(150, 198, 117, 25);
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				shutdown();

			}
		});
		panel.add(btnCancel);

		passwordField = new JPasswordField();
		passwordField.setEnabled(false);
		passwordField.setBounds(150, 100, 150, 20);
		panel.add(passwordField);

		btnRegister = new JButton("Register");
		btnRegister.setEnabled(false);
		btnRegister.setBounds(306, 198, 117, 25);
		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String login = tfLogin.getText();
				int pwd = 0;
				if (login.equals("")) {
					setStatusLine("Enter valid login!!!!");
				} else if (passwordField.getPassword().length < 1) {
					setStatusLine("Enter correct password!");
				} else {
					pwd = (new String(passwordField.getPassword())).hashCode();
					jabberClient.doRegister(login, pwd);
				}
			}
		});
		panel.add(btnRegister);

	}

	public void shutdown() {
		if (jabberClient != null) {
			jabberClient.setJabberClientListener(null);
			jabberClient.shutdown();
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

	}

	public void setStatusLine(final String message) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				lblStatus.setText(message);

			}
		});

	}

	public void start() {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				frame.setVisible(true);

			}
		});
	}

	@Override
	public void statusChanged() {
		if (jabberClient != null) {
			EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					lblStatus.setText(jabberClient.getStatusMsg());

				}
			});
		}

	}

	@Override
	public void registerOK() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loginOK() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				ClientListGUI clientGUI=new ClientListGUI();
				clientGUI.setJabberClient(jabberClient);
				jabberClient.setJabberClientListener(clientGUI);
				clientGUI.setUser("User: " + jabberClient.getUser().getName() + " ( ID: " + jabberClient.getUser().getId()+ " )");
				clientGUI.start();
				
			}
		}).start();

frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		
		
	}

	@Override
	public void connectOK() {
		tfLogin.setEnabled(true);
		passwordField.setEnabled(true);
		btnLogin.setEnabled(true);
		btnRegister.setEnabled(true);
		
	}

	@Override
	public void addUser(int id, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(int id, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userListUpdated(List<User> users) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newMessageArrived(int parseInt, String string) {
		// TODO Auto-generated method stub
		
	}
}
