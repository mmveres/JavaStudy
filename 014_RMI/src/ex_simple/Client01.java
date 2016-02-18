package ex_simple;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client01 {
	public static void main(String[] args) throws NotBoundException, RemoteException, MalformedURLException {
		String url = "//localhost:59001/Array";
		MyArray q = (MyArray) Naming.lookup(url);
		System.out.println("RMI object found");
		while (true)
			q.Add(Integer.valueOf(1));
	}
}
