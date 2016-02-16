package jabber.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jabber.dao.MessageDAO;
import jabber.dao.UserDAO;
import jabber.entities.User;

public class SingleClientServer extends Thread {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private volatile boolean stop;
	public final int id;
	private static int counter = 1000;
	private JabberServer jabberServer;
	private UserDAO userDAO;
	private MessageDAO msgDAO;
	private User user;


	public SingleClientServer(Socket s, JabberServer jabberServer) throws IOException {
		socket = s;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		this.jabberServer = jabberServer;
		id = counter++;
		start();
		userDAO = new UserDAO();
		msgDAO= new MessageDAO();
		user = new User("DEFAULT",0);
	}

	public void run() {
		System.out.println("Thread server " + id + " started.");
		try {
			while (!stop) {
				String str = in.readLine();
				if (str == null) {
					stop = true;
				} else {
					parseMessage(str);
				}
			}

		} catch (IOException e) {
			System.err.println("IO Exception");
		} finally {
			try {
				System.out.println("closing... " + id);
				socket.close();
				jabberServer.removeSingleClientServer(user.getId());
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (IOException e) {
				System.err.println("Socket not closed");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// parses input string
	// format could be
	// <MESSAGE_HEADER> + <SPLIT> + <RECEIVER_ID/ALL> +<SPLIT>+ <MESSAGE_TEXT>
	// or
	// <COMMAND_HEADER>+<COMMAND>+<COMMAND_OPTIONS>
	private void parseMessage(String str) {
		String[] in = null;
		in = str.split(JabberServer.SPLIT);
		
		
		//MESSAGE parsing block
		if (str.startsWith(JabberServer.MESSAGE_HEADER)) {
			
			//BROADCAST case
			if (in[1].equals(JabberServer.ALL)) {
				
				jabberServer.sendAll(JabberServer.MESSAGE_HEADER + JabberServer.SPLIT + JabberServer.ALL
						+ JabberServer.SPLIT + in[2]);
				try {
					msgDAO.addMessage(user.getId(), 0, in[2]);
				} catch (Exception e) {
					System.err.println("Error adding message - to all");
					e.printStackTrace();
				}
				
			//SELECTED ADDRESSEE case
			}else{
				jabberServer.sendTo(Integer.parseInt(in[1]),in[2]);
				try {
					msgDAO.addMessage(user.getId(), Integer.parseInt(in[1]), in[2]);
				} catch (Exception e) {
					System.err.println("Error adding message - to one");
					e.printStackTrace();
				}
			}

		}
		
		//COMMAND parsing block
		if (str.startsWith(JabberServer.COMMAND_HEADER)) {

			// LOGIN part
			if (in[1].equals(JabberServer.CMD_DO_LOGIN)) {
				int id = checkCredentials(in[2], in[3]);
				if (id != 0) {
					user.setId(id);
					user.setName(in[2]);
					sendMessage(JabberServer.SRV_REPLY + JabberServer.SPLIT + JabberServer.CMD_DO_LOGIN
							+ JabberServer.SPLIT + JabberServer.OK+JabberServer.SPLIT +id);
					jabberServer.sendAll(JabberServer.COMMAND_HEADER + JabberServer.SPLIT + JabberServer.CMD_ADD_USER
							+ JabberServer.SPLIT + id+JabberServer.SPLIT + in[2]);

				} else {
					sendMessage(JabberServer.SRV_REPLY + JabberServer.SPLIT + JabberServer.CMD_DO_LOGIN
							+ JabberServer.SPLIT + JabberServer.BAD);
				}
			}

			// REGISTER PART
			if (in[1].equals(JabberServer.CMD_DO_REGISTER)) {
				int id = checkCredentials(in[2], in[3]);
				if (id != 0) {
					sendMessage(JabberServer.SRV_REPLY + JabberServer.SPLIT + JabberServer.CMD_DO_REGISTER
							+ JabberServer.SPLIT + JabberServer.BAD);

				} else {
					if (addUserToDB(in[2], in[3])) {
						sendMessage(JabberServer.SRV_REPLY + JabberServer.SPLIT + JabberServer.CMD_DO_REGISTER
								+ JabberServer.SPLIT + JabberServer.OK);
					} else {
						sendMessage(JabberServer.SRV_REPLY + JabberServer.SPLIT + JabberServer.CMD_DO_REGISTER
								+ JabberServer.SPLIT + JabberServer.BAD);
					}

				}
			}

			// LIST_ACTIVE
			if (in[1].equals(JabberServer.CMD_LIST_ACTIVE)) {
				String message = "";
				User []clients = jabberServer.getActiveUsers();
				if (clients != null&&clients.length>0) {
					message = clients[0].getId()+JabberServer.CMD_SPLIT + clients[0].getName();
					for (int i = 1; i < clients.length; i++) {
						message = message + JabberServer.CMD_SPLIT + clients[i].getId()+JabberServer.CMD_SPLIT + clients[i].getName();
					}
					sendMessage(JabberServer.SRV_REPLY + JabberServer.SPLIT + JabberServer.CMD_LIST_ACTIVE
							+ JabberServer.SPLIT + message);

				}
			}

		}
	}

	private boolean addUserToDB(String name, String pwd) {
		boolean result = false;
		int pass = Integer.parseInt(pwd);
		try {
			userDAO.addUser(new User(name, pass));
			result = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	private int checkCredentials(String name, String pwd) {
		int result = 0;
		int pass = 0;
		try {
			List<User> users = userDAO.getUsersByName(name);
			pass = Integer.parseInt(pwd);
			if (users.size() > 0) {
				for (User user : users) {
					if (user.getPwd() == pass)
						result = user.getId();
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return result;
		}

	}

	private void setClientName(String string) {
		user.setName(string);
	}

	private boolean setClientID(String string) {
		boolean done = false;
		try {
			user.setId(Integer.parseInt(string));
			done = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return done;

	}


	public void sendMessage(String message) {
		if (out != null) {
			out.println(message);
		}

	}
	
	public User getUser() {
		return user;
	}
	
}