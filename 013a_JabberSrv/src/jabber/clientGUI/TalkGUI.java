package jabber.clientGUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sun.xml.internal.ws.api.databinding.MappingInfo;

import jabber.client.JabberClient;
import jabber.client.JabberClientListener;
import jabber.entities.User;

import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class TalkGUI {

	private JFrame frame;
	private JTextField tfMessage;
	private JButton btnSend;
	private JTextArea txaMessages;
	private JLabel lblStatus;
	private User user;
	private ClientListGUI mainWindow;
	
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		setStatusMessage("Talking with: " + user.getName()+ " ( " + user.getId() + " ) ");
	}

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TalkGUI window = new TalkGUI(null);
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
	public TalkGUI(ClientListGUI mainWindow) {
		this.mainWindow=mainWindow;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(15, 12, 193, 15);
		panel.add(lblStatus);
		
		tfMessage = new JTextField();
		tfMessage.setBounds(15, 296, 370, 64);
		panel.add(tfMessage);
		tfMessage.setColumns(10);
		
		txaMessages = new JTextArea();
		txaMessages.setBounds(15, 36, 456, 248);
		txaMessages.setEditable(false);
		panel.add(txaMessages);
		
		btnSend = new JButton("Send");
		btnSend.setBounds(397, 300, 74, 25);
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfMessage.getText().equals("")){
					setStatusMessage("Nothing to send, pls enter text!");
				}else{
//					jabberClient.sendTextMessage(tfMessage.getText(), address);
				}
				tfMessage.setText("");
				
			}
		});
		panel.add(btnSend);

	}
	
	private void setStatusMessage(final String string) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				lblStatus.setText(string);
				
			}
		});
		
	}

	public void start(){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				frame.setVisible(true);
				
			}
		});
		if(mainWindow.hasMessagesFrom(user.getId())){
			
		}

	}

	public void appendNewMessage(final String msgText){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				txaMessages.append(msgText);
				
			}
		});
	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null)return false;
		if(!(obj instanceof TalkGUI)) return false;
		if (obj==this) return true;
		if(this.getUser().getId()==((User)obj).getId())return true;
		return false;
	}
	
	

}
