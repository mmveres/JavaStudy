package jabber.client;

//: c15:JabberClient.java
//Î÷åíü ïðîñòîé êëèåíò, êîòîðûé ïðîñòî ïîñûëàåò
//ñòðîêè íà ñåðâåð è ÷èòàåò ñòðîêè,
//ïîñûëàåìûå ñåðâåðîì.
//{RunByHand}
import java.net.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jabber.entities.User;
import jabber.server.JabberServer;

import java.io.*;

public class JabberClient {
	public static final int SEND_ALL=0;
	private BufferedReader in;
	private PrintWriter out;
	private InetAddress addr;
	private BufferedReader keyboard;
	private final long id;
	private static int counter;
	private volatile boolean stop;
	private Socket socket;
	private int steps;
	private boolean connected;
	private User user;
	private JabberClientListener jabberClientListener;
	private String statusMsg;

	public JabberClientListener getJabberClientListener() {
		return jabberClientListener;
	}

	public void setJabberClientListener(JabberClientListener jcl) {
		this.jabberClientListener = jcl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatusMsg() {
		return statusMsg;
	}
	
	
	public JabberClient() {
		this(null);
	}

	public JabberClient(InetAddress addr) {
		if (addr == null) {
			try {
				this.addr = InetAddress.getByName(null);

			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		id = System.currentTimeMillis() + (counter++) * 31;
	}

	public long getId() {
		return id;
	}

	public void start() {
		int cnt=0;
		while (!connected) {

			try {
				socket = new Socket(addr, JabberServer.PORT);
				connected = true;
			} catch (IOException e) {
				setStatusMessage("waiting for connection... "+ cnt + " sec.");
				cnt++;
				try {
					TimeUnit.MILLISECONDS.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
				}

			}
		}
		if (connected) {
			try {
				if(jabberClientListener!=null)jabberClientListener.connectOK();
				setStatusMessage("Connected to server:" + addr.getHostName());
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
				keyboard = new BufferedReader(new InputStreamReader(System.in));

				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							while (!stop) {
								// System.out.println("waiting message...");
								String str = in.readLine();
								if (str == null) {
									stop = true;

								} else {
									parseMessage(str);
								}
							}

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}).start();

				// makeIntroduction();
				// requestActiveClientList();

				while (!stop) {
					// System.out.println("write message...");
					String message = keyboard.readLine();
					if (message.equals("*END")) {
						stop = true;
					} else {
						// newMessage=true;
						sendMessage(JabberServer.MESSAGE_HEADER + JabberServer.SPLIT + JabberServer.ALL
								+ JabberServer.SPLIT + message);
					}
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				if (socket != null) {
					try {
						socket.close();
						System.out.println("Client closed.");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

	
	
	private void setStatusMessage(String string) {
		System.out.println(string);
		statusMsg=string;
		if (jabberClientListener != null) {
			jabberClientListener.statusChanged();;
		}

	}

	// SYNTAX is
	// <OK><SPLIT><OPTIONS> - to clarify previously sent command is done
	// <MESSAGE><SPLIT><SENDER_ID/ALL><SPLIT><MESSAGE_TEXT>
	// <COMMAND_HEADER><SPLIT><COMMAND><SPLIT><OPTIONS>
	
	private void parseMessage(String str) {
		String[] in = str.split(JabberServer.SPLIT);
		
		//server replies part
		if (str.startsWith(JabberServer.SRV_REPLY)) {
			
			System.out.print("service message from server: ");
			
			//registered?
			if (in[1].equals(JabberServer.CMD_DO_REGISTER)) {
				if(in[2].equals(JabberServer.BAD)){
					setStatusMessage("User exists or connection problem, try again!");
				}else{
					if(jabberClientListener!=null)jabberClientListener.registerOK();
					setStatusMessage("Succsesfully registered, now login!");
				}
			}
			
			//login check
			if (in[1].equals(JabberServer.CMD_DO_LOGIN)) {
				if(in[2].equals(JabberServer.BAD)){
					setStatusMessage("Login failed, check input and try again!");
				}else{
					setStatusMessage("Login OK!");
					user.setId(Integer.parseInt(in[3]));
					if(jabberClientListener!=null)jabberClientListener.loginOK();

				}
			}
			
			
			
			if (in[1].equals(JabberServer.CMD_LIST_ACTIVE)) {
				if(in[2].length()>0){
					String []list=in[2].split(JabberServer.CMD_SPLIT);
					System.out.println(Arrays.toString(list));
					List<User> users=new LinkedList<>();
					for(int i=0;i<list.length;i=i+2){
						int id = Integer.parseInt(list[i]);
						if(id!=user.getId())users.add(new User(id, list[i+1], "", 0));
						
					}
					jabberClientListener.userListUpdated(users);
				}
				
			}
		
		//server commands part
		} else if (str.startsWith(JabberServer.COMMAND_HEADER)) {
			
			//add user to list
			if(in[1].equals(JabberServer.CMD_ADD_USER)){
				jabberClientListener.addUser(Integer.parseInt(in[2]), in[3]);
			}
			
			
		//messages part
		} else if (str.startsWith(JabberServer.MESSAGE_HEADER)) {
			if (in[1].equals(JabberServer.ALL)) {
				System.out.println("Broadcast received: " + in[2]);
			} else {
				System.out.println("From " + getNameByID(in[1]) + " : " + in[2]);
				
				jabberClientListener.newMessageArrived(Integer.parseInt(in[1]),in[2]);
			}

		}

	}

	private String getNameByID(String string) {
		return string;
	}

	public void requestActiveClientList() {
		setStatusMessage("Requesting active clients list...");
		sendMessage(JabberServer.COMMAND_HEADER + JabberServer.SPLIT + JabberServer.CMD_LIST_ACTIVE);

	}
	
	public void doLogin(String login, int pwd){
		if(user==null){
			user=new User(login,pwd);
		}else{
			user.setName(login);
			user.setPwd(pwd);
		}	
		setStatusMessage("Making logon...");
		sendMessage(JabberServer.COMMAND_HEADER + JabberServer.SPLIT + JabberServer.CMD_DO_LOGIN+JabberServer.SPLIT+login+JabberServer.SPLIT+pwd);

	}
	
	

	private void makeIntroduction() {
		setStatusMessage("Sending ID to server...");
		// newMessage = true;
		sendMessage(
				JabberServer.COMMAND_HEADER + JabberServer.SPLIT + JabberServer.CMD_SET_ID + JabberServer.SPLIT + id);
		// newMessage = true;
		// sendMessage(JabberServer.COMMAND_HEADER + JabberServer.SPLIT +
		// JabberServer.CMD_SET_NAME + JabberServer.SPLIT
		// + "Kote");

	}

	private void sendMessage(String string) {
		// if (newMessage) {
		out.println(string);
		// newMessage = false;
		// }

	}

	public void sendTextMessage(String message, long idTo) {
		if (message == null)
			return;
		if (idTo == 0) {
			sendMessage(
					JabberServer.MESSAGE_HEADER + JabberServer.SPLIT + JabberServer.ALL + JabberServer.SPLIT + message);
		}
	}
	
	public void shutdown(){
		stop=true;
	}

	public static void main(String[] args) throws IOException {
		JabberClient jc = new JabberClient();
		jc.start();

	}

	public void doRegister(String login, int pwd) {
		if(user==null){
			user=new User(login,pwd);
		}else{
			user.setName(login);
			user.setPwd(pwd);
		}
		setStatusMessage("Registering...");
		sendMessage(JabberServer.COMMAND_HEADER + JabberServer.SPLIT + JabberServer.CMD_DO_REGISTER+JabberServer.SPLIT+login+JabberServer.SPLIT+pwd);

		
	}
}