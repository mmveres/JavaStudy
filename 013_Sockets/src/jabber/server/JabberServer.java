package jabber.server;

import java.io.*;
import java.net.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class JabberServer {
	public static final int PORT = 8080;
	public static final String MESSAGE_HEADER="<!MESSAGE>";
	public static final String SPLIT="<!SPLIT>";
	public static final String CMD_SPLIT="<!CMD_SPLIT>";
	public static final String COMMAND_HEADER="<!CMD>";
	public static final String CMD_CLIENT_EXIT="<!CLIENT_EXIT>";
	public static final String CMD_REMOVE_ID="<!REMOVE_ID>";
	public static final String CMD_ADD_ID="<!ADD_ID>";
	public static final String CMD_GET_ALL="<!GET_ALL>";
	public static final String CMD_GET_NAME_FOR_ID="<!GET_NAME_FOR_ID>";
	public static final String CMD_SET_ID="<S!ET_ID>";
	public static final String CMD_SET_NAME="<!SET_NAME>";
	public static final String CMD_GET_LIST_ACTIVE="<!GET_LIST_ACTIVE>";
	public static final String ALL="<!ALL>";
	public static final String END="<!END>";
	public static final String SRV_REPLY="<!SRV_REPLY!>";
	private List<SingleClientServer> serverThreads = new LinkedList<>();
	private static JabberServer jabberServer;
	private volatile boolean active;
	private boolean listBlocked;

	
	
	public boolean isActive() {
		return active;
	}
	
	public static void main(String[] args) throws IOException {
		if(!JabberServer.getJabberServer().isActive())JabberServer.getJabberServer().start();

	}

	private JabberServer() {
	}

	public static JabberServer getJabberServer() {
		if (jabberServer == null) {
			jabberServer = new JabberServer();
		}
		return jabberServer;
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
							serverThreads.add(new SingleClientServer(socket, jabberServer));
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

	public synchronized void removeSingleClientServer(long id) {
		while(listBlocked){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		listBlocked=true;
		sendAll(COMMAND_HEADER+SPLIT+CMD_REMOVE_ID+SPLIT+id);
		Iterator<SingleClientServer> iterator=serverThreads.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getClientID()==id){
				iterator.remove();
				break;
			}
		}
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
			for (SingleClientServer singleClientServer : serverThreads) {
				singleClientServer.sendMessage(message);
			}
		}
		listBlocked=false;
		notifyAll();
	}
	
	public void sendAll(String message) {
		if(serverThreads.size()>0){
			for (SingleClientServer singleClientServer : serverThreads) {
				singleClientServer.sendMessage(message);
			}
		}
	}
	
	public long []getActiveIDs(){
		long []clientList=new long[serverThreads.size()];
		int counter=0;
		for (SingleClientServer singleClientServer : serverThreads) {
			clientList[counter++]=singleClientServer.getClientID();
		}
		return clientList;
	}
}