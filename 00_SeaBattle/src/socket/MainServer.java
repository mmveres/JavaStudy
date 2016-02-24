package socket;

import java.io.*;
import java.net.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import entities.User;


public class MainServer {
	public static final int PORT = 8080;
	public static final String MESSAGE_HEADER="<!MESSAGE>";
	public static final String SPLIT="<!SPLIT>";
	public static final String CMD_SPLIT="<C!>";
	public static final String COMMAND_HEADER="<!CMD>";
	public static final String CMD_CLIENT_EXIT="<!CLIENT_EXIT>";
	public static final String CMD_REMOVE_ID="<!REMOVE_ID>";
	public static final String CMD_ADD_USER="<!ADD_USER>";
	public static final String CMD_GET_ALL="<!GET_ALL>";
	public static final String CMD_GET_NAME_FOR_ID="<!GET_NAME_FOR_ID>";
	public static final String CMD_SET_ID="<SET_ID>";
	public static final String CMD_SET_NAME="<!SET_NAME>";
	public static final String CMD_DO_LOGIN="<!DO_LOGIN>";
	public static final String CMD_DO_REGISTER="<!DO_REGISTER>";
	public static final String CMD_SET_PASSWORD="<!SET_PASSWORD>";
	public static final String CMD_LIST_ACTIVE="<!LIST_ACTIVE>";
	public static final String ALL="<!ALL>";
	public static final String END="<!END>";
	public static final String OK="<!OK>";
	public static final String BAD="<!BAD>";
	public static final String SRV_REPLY="<!SRV_REPLY!>";
	private List<SingleGameServer> serverThreads = new LinkedList<>();
	private static MainServer mainServer;
	private volatile boolean active;
	private boolean listBlocked;

	
	
	public boolean isActive() {
		return active;
	}
	
	public static void main(String[] args) throws IOException {
		if(!MainServer.getMainServer().isActive())MainServer.getMainServer().start();

	}

	private MainServer() {
	}

	public static MainServer getMainServer() {
		if (mainServer == null) {
			mainServer = new MainServer();
		}
		return mainServer;
	}

	public void start() {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				// start main server
				ServerSocket s=null;
				try {
					s = new ServerSocket(PORT);
					System.out.println("Main Server: Started");
					// launch thread which will start single servers for all
					// incoming
					// connections
					active=true;
					while (active) {
						try {
							Socket socket;
							socket = s.accept();
							serverThreads.add(new SingleGameServer(mainServer,socket));
							System.out.println("Main Server: size "+ serverThreads.size());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} finally {
							// try {
							// socket.close();
							// } catch (IOException e) {
							// // TODO Auto-generated catch block
							// e.printStackTrace();
							// }
						}

					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if(s!=null){
						try {
							s.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}
		}).start();

	}

	public synchronized void removeSingleGameServer(SingleGameServer singleGameServer) {
		while(listBlocked){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		listBlocked=true;
			serverThreads.remove(singleGameServer);
		
		sendAll(COMMAND_HEADER+SPLIT+CMD_REMOVE_ID+SPLIT);
		System.out.println("Main Server: size "+ serverThreads.size());
		listBlocked=false;
		notifyAll();
		
	}

	public synchronized void sendAllsynchronized(String message) {
		while(listBlocked){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		listBlocked=true;
		if(serverThreads.size()>0){
			for (SingleGameServer singleGameServer : serverThreads) {
				singleGameServer.sendMessage(message);
			}
		}
		listBlocked=false;
		notifyAll();
	}
	
	public void sendAll(String message) {
		if(serverThreads.size()>0){
			for (SingleGameServer singleGameServer  : serverThreads) {
				singleGameServer.sendMessage(message);
			}
		}
	}
	
	public User []getActiveUsers(){
		User []clientList=new User[serverThreads.size()];
		int counter=0;
		for (SingleGameServer singleGameServer : serverThreads) {
			clientList[counter++]=singleGameServer.getUser();
		}
		return clientList;
	}

	public void sendTo(int userIDTo, String string) {
		
		
	}
}