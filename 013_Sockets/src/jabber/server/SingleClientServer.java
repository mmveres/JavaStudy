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
import java.util.concurrent.TimeUnit;

public class SingleClientServer extends Thread {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private volatile boolean stop;
	private long clientID;
	private String clientName;
	public final int id;
	private static int counter = 1000;
	private JabberServer jabberServer;

	public SingleClientServer(Socket s, JabberServer jabberServer) throws IOException {
		socket = s;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		this.jabberServer = jabberServer;
		id = counter++;
		start();
	}

	public void run() {
		System.out.println("Thread server "+ id+ " started.");
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
				jabberServer.removeSingleClientServer(clientID);
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
//		System.out.println(Arrays.toString(in));

		if (str.startsWith(JabberServer.MESSAGE_HEADER)) {

			if (in[1].equals(JabberServer.ALL)) {
				jabberServer.sendAll(JabberServer.MESSAGE_HEADER + JabberServer.SPLIT + JabberServer.ALL
						+ JabberServer.SPLIT + in[2]);
			}

		}

		if (str.startsWith(JabberServer.COMMAND_HEADER)) {
			if (in[1].equals(JabberServer.CMD_SET_ID)) {
				if (setClientID(in[2])) {
					sendMessage(JabberServer.SRV_REPLY + JabberServer.SPLIT + JabberServer.CMD_SET_ID + JabberServer.SPLIT
							+ clientID);
				}

			}
			if (in[1].equals(JabberServer.CMD_SET_NAME)) {
				setClientName(in[2]);
				sendMessage(JabberServer.SRV_REPLY + JabberServer.SPLIT + JabberServer.CMD_SET_NAME + JabberServer.SPLIT
						+ clientName);
			}
			if(in[1].equals(JabberServer.CMD_GET_LIST_ACTIVE)){
				String message="";
				long []clients=jabberServer.getActiveIDs();
				message = ""+clients[0];
				if(clients!=null){
					for (int i = 1; i < clients.length; i++) {
						message=message+JabberServer.CMD_SPLIT+clients[i];
					}
					for (long l : clients) {
						
					}
					sendMessage(JabberServer.SRV_REPLY+JabberServer.SPLIT+JabberServer.CMD_GET_LIST_ACTIVE+JabberServer.SPLIT+message);
					
				}
				}
				
		}
	}

	private void setClientName(String string) {
		clientName = string;
	}

	private boolean setClientID(String string) {
		boolean done = false;
		try {
			clientID = Long.parseLong(string);
			done = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return done;

	}

	public long getClientID() {
		return clientID;
	}

	public String getClientName() {
		return clientName;
	}

	public void sendMessage(String message) {
		if (out != null) {
			out.println(message);
		}

	}
}