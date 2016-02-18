package ex_simple;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client02 {
	public static void main(String[] args) throws NotBoundException, RemoteException, MalformedURLException {
		String url = "//localhost:59001/Array";
		MyArray Q = (MyArray) Naming.lookup(url);
		System.out.println("RMI object found");
		while (true)
			System.out.println(Q.Sum());
	}
}
