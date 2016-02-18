package ex_simplier;

import java.rmi.Remote;
import java.rmi.RemoteException;

interface RMIServer extends Remote{
	public String hello() throws RemoteException;

}
