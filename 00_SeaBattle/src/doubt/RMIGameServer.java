package doubt;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entities.User;


public interface RMIGameServer extends Remote {
	
	ClientConnection getConnection(final User user) throws RemoteException;
	boolean isGameActive()throws RemoteException;
	
	
	

}
