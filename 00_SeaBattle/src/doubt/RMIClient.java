package doubt;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import entities.User;

public class RMIClient {
	private User user;
	private ClientConnection connection;
	private String url;
	RMIGameServer gameServer;
	
	public RMIClient(User user) {
		this.user=user;
		url = "//localhost:"+ Server.REGISTRY_PORT+"/"+Server.SERVER_NAME;
		try {
			gameServer = (RMIGameServer) Naming.lookup(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("RMI object found");
	
	}
	
	public void start(){
		
		try {
			connection=gameServer.getConnection(user);
			connection.doStop();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
