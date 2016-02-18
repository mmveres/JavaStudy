package ex_simple;

import java.rmi.Remote;
import java.rmi.RemoteException;

interface MyArray extends Remote{
	public void Add(Integer v) throws RemoteException;
	public int Sum() throws RemoteException;

}
