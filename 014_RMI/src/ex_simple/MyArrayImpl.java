package ex_simple;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MyArrayImpl extends UnicastRemoteObject implements MyArray {
	private ArrayList<Integer> x;

	public MyArrayImpl() throws RemoteException {
		x = new ArrayList<Integer>();
	}

	public void Add(Integer v) throws RemoteException {
		synchronized (x) {
			x.add(v);
		}
	}

	public int Sum() throws RemoteException {
		int sum = 0;
		synchronized (x) {
			for (Object i : x)
				sum += (Integer) i;
		}
		return sum;
	}
}
