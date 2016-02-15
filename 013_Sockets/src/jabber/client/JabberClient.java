package jabber.client;

//: c15:JabberClient.java
//Î÷åíü ïðîñòîé êëèåíò, êîòîðûé ïðîñòî ïîñûëàåò
//ñòðîêè íà ñåðâåð è ÷èòàåò ñòðîêè,
//ïîñûëàåìûå ñåðâåðîì.
//{RunByHand}
import java.net.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import jabber.server.JabberServer;

import java.io.*;

public class JabberClient {
	private BufferedReader in;
	private PrintWriter out;
	private InetAddress addr;
	private BufferedReader keyboard;
	private final long id;
	private static int counter;
	private volatile boolean stop;
	private Socket socket;
	private int steps;
	private boolean connected;;

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

		while (!connected) {
			try {
				socket = new Socket(addr, JabberServer.PORT);
				connected = true;
			} catch (IOException e) {
				System.out.println("waiting for connection...");
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
				System.out.println("Started client " + id + " , socket " + socket);
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

				makeIntroduction();
				requestActiveClientList();

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



	// could be
	// <OK>JabberServer.SPLIT<OPTIONS> - to clarify previously sent command is
	// done
	// <MESSAGE><SPLIT><SENDER_ID/ALL><SPLIT><MESSAGE_TEXT>
	// <COMMAND_HEADER>JabberServer.SPLIT<COMMAND>JabberServer.SPLIT<OPTIONS>
	private void parseMessage(String str) {
		String[] in = str.split(JabberServer.SPLIT);
		if (str.startsWith(JabberServer.SRV_REPLY)) {
			System.out.print("service message from server: ");
			if (in[1].equals(JabberServer.CMD_SET_ID)) {
				System.out.println("ID " + in[2] + " set ok!");
			}
			if (in[1].equals(JabberServer.CMD_SET_NAME)) {
				System.out.println("name " + in[2] + " set ok!");
			}
			if(in[1].equals(JabberServer.CMD_GET_LIST_ACTIVE)){
				System.out.println("" + in[2]);
			}
				
		

		} else if (str.startsWith(JabberServer.COMMAND_HEADER)) {
			System.out.println("command message from server ...");
			System.out.println(str);
		} else if (str.startsWith(JabberServer.MESSAGE_HEADER)) {
			if (in[1].equals(JabberServer.ALL)) {
				System.out.println("Broadcast received: " + in[2]);
			} else {
				System.out.println("From " + getNameByID(in[1]) + " : " + in[2]);
			}

		}

	}

	private String getNameByID(String string) {
		return string;
	}
	
	private void requestActiveClientList() {
		System.out.println("Requesting active clients list...");
		sendMessage(
				JabberServer.COMMAND_HEADER + JabberServer.SPLIT + JabberServer.CMD_GET_LIST_ACTIVE);
		
	}
	private void makeIntroduction() {
		System.out.println("Sending name and ID to server...");
		// newMessage = true;
		sendMessage(
				JabberServer.COMMAND_HEADER + JabberServer.SPLIT + JabberServer.CMD_SET_ID + JabberServer.SPLIT + id);
		// newMessage = true;
		sendMessage(JabberServer.COMMAND_HEADER + JabberServer.SPLIT + JabberServer.CMD_SET_NAME + JabberServer.SPLIT
				+ "Kote");

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

	public static void main(String[] args) throws IOException {
		JabberClient jc = new JabberClient();
		jc.start();

	}
}