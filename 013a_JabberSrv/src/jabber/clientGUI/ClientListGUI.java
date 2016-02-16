package jabber.clientGUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import jabber.client.JabberClient;
import jabber.client.JabberClientListener;
import jabber.entities.Message;
import jabber.entities.User;

import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

public class ClientListGUI implements JabberClientListener {

	private class UserHasMsg extends User {
		boolean hasMsg;

		public UserHasMsg(User user) {
			super(user.getId(), user.getName(), user.getComments(), user.getPwd());
		}

		public UserHasMsg(int id, String name, String comments, int pwd) {
			super(id, name, comments, pwd);
		}

		public boolean isHasMsg() {
			return hasMsg;
		}

		public void setHasMsg(boolean hasMsg) {
			this.hasMsg = hasMsg;
		}

		@Override
		public String toString() {
			return "" + (hasMsg ? "*** - " : "") + getName() + " ( " + getId() + " ) ";
		}

	}

	private JFrame frame;
	private JabberClient jabberClient;
	private int address = 0;
	private JLabel lblStatus;
	private JLabel lblMe;
	private List<TalkGUI> talkWindows = new LinkedList<>();
	private JPanel userPanel;
	private DefaultListModel<UserHasMsg> userListModel = new DefaultListModel<>();
	private JList<UserHasMsg> userList;
	private List<Message> messages = new LinkedList<>();

	/**
	 * Launch the application.
	 */

	synchronized boolean hasMessagesFrom(int userID) {
		boolean result = false;
		for (Message message : messages) {
			if (message.getIdFrom() == userID) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	
	synchronized List<Message> popMessagesFrom(int userID){
		List<Message> list = new LinkedList<>();
		Iterator<Message> iter=messages.iterator();
		while(iter.hasNext()){
			Message msg=iter.next();
			if(msg.getIdFrom()==userID){
				list.add(msg);
				iter.remove();
			}
		}
		return list;
	}

	public void setJabberClient(JabberClient jabberClient) {
		this.jabberClient = jabberClient;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientListGUI window = new ClientListGUI();
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
	public ClientListGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(200, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		userPanel = new JPanel();
		frame.getContentPane().add(userPanel, BorderLayout.CENTER);
		userPanel.setLayout(null);

		lblMe = new JLabel(" ");
		lblMe.setBounds(15, 10, 170, 15);
		userPanel.add(lblMe);

		lblStatus = new JLabel(" ");
		lblStatus.setBounds(15, 345, 170, 15);
		userPanel.add(lblStatus);

		userList = new JList<UserHasMsg>();
		userList.setBounds(15, 35, 170, 300);
		userList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {

					// Double-click detected
					int index = userList.locationToIndex(evt.getPoint());
					openTalkWindow(userList.getSelectedValue());
				} else if (evt.getClickCount() == 3) {

					// Triple-click detected
					int index = userList.locationToIndex(evt.getPoint());
				}
			}
		});
		userPanel.add(userList);

	}

	protected void openTalkWindow(User user) {
		TalkGUI talkWindow = new TalkGUI(this);
		talkWindows.add(talkWindow);
		talkWindow.setUser(user);
		talkWindow.start();
		talkWindow = null;
	}

	protected void setStatusMessage(final String string) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				lblStatus.setText(string);

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
		jabberClient.requestActiveClientList();

	}

	@Override
	public void statusChanged() {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerOK() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loginOK() {
		// TODO Auto-generated method stub

	}

	@Override
	public void connectOK() {
		// TODO Auto-generated method stub

	}

	public void setUser(final String name) {
		lblMe.setText(name);
	}

	@Override
	public void addUser(int id, String name) {
		userListModel.addElement(new UserHasMsg(id, name, "", 0));
		userList.setModel(userListModel);

	}

	@Override
	public void removeUser(int id, String name) {
		userListModel.removeElement(new UserHasMsg(id, name, "", 0));
		userList.setModel(userListModel);

	}

	@Override
	public void userListUpdated(List<User> users) {
		userList.removeAll();
		for (User user : users) {
			userListModel.addElement(new UserHasMsg(user));

		}
		userList.setModel(userListModel);

	}


	@Override
	public void newMessageArrived(int useriIDFrom, String messageText) {
		int index=getTalkWindowIndex(useriIDFrom);
		if(index!=-1){
			appendMessage(messageText, index);
		}else{
			
		}
		
	}
	
	private synchronized void appendMessage(String msgText, int index){
		talkWindows.get(index).appendNewMessage(msgText);
	}

	private synchronized int getTalkWindowIndex(int useriIDFrom) {
		int	result = -1;
		for(int i=0;i<talkWindows.size();i++){
			if(talkWindows.get(i).getUser().getId()==useriIDFrom){
				result=i;
				break;
			}
		}
		return result;
	}
}
