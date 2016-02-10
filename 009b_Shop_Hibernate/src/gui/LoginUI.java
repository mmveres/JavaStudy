package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import application.LoginUIListener;
import application.ShopApplication;

public class LoginUI extends JPanel {
	private String btOKLabel = "  OK   ";
	private String loginLabel = "Login";
	private String passwordLabel = "Password";
	private String login;
	private String password;
	private int height = 20;
	private JLabel lbLogin = new JLabel(loginLabel);
	private JTextField tLogin = new JTextField(15);
	private JLabel lbPass = new JLabel(passwordLabel);
	private JPasswordField tPass = new JPasswordField(15);
	private JButton btOK = new JButton(btOKLabel);
	private LoginUIListener loginUIListener;

	public LoginUI() {
		setBorder(new TitledBorder("Login"));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(Box.createVerticalStrut(height));
		add(lbLogin);
		add(tLogin);
		tLogin.setText("shop_suppadm");
		add(Box.createVerticalStrut(height));
		add(lbPass);
		add(tPass);
		tPass.setText("supplier");
		add(Box.createVerticalStrut(height));
		add(btOK);
		add(Box.createVerticalStrut(height));
		btOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkFields();


			}



		});
	}
	
	private void checkFields() {
		password=new String(tPass.getPassword());
		login=tLogin.getText();
		if(login.equals("")){
			showMessage("Login can't be empry!");
		}else if(password.equals("")){
			showMessage("Password can't be empty!");
		}else if (loginUIListener != null) {
			
			loginUIListener.doLogin(login, password);
		}
		
	}

	public void setLoginUIListener(LoginUIListener loginPanelListener) {
		this.loginUIListener = loginPanelListener;
	}

	public void showMessage(String text) {
		JOptionPane.showMessageDialog(this, text);

	}

}
