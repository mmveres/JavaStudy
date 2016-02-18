package ex_simple;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		MyArrayImpl helloImpl = new MyArrayImpl();
		Registry registry = LocateRegistry.createRegistry(59001);
		registry.rebind("Array", helloImpl);
		System.out.println("Server started!");
	}
}
