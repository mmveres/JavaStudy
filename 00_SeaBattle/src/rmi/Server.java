package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Server {
	public static final String SERVER_NAME="SeaBattle";
	public static final int REGISTRY_PORT=59001;
	public static void main(String[] args) {
		RMIGameServer_Impl gameServer;
		try {
			gameServer = new RMIGameServer_Impl();
			Registry registry = LocateRegistry.createRegistry(REGISTRY_PORT);
			registry.rebind(SERVER_NAME, gameServer);
			System.out.println("Server started!");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
