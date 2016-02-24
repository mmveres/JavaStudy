package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entities.User;
import entities.cells.CoordinateCell;
import entities.cells.ShotResult;


public interface RMIGameServer extends Remote {
	
	long addUser(User user) throws RemoteException;
	boolean putShot(CoordinateCell cell, long tempID) throws RemoteException;
	CoordinateCell getShot(long tempID) throws RemoteException;
	boolean putResult(ShotResult result, long tempID) throws RemoteException;
	ShotResult getResult(long tempID) throws RemoteException;
	boolean isAlive() throws RemoteException;
	void stop(long tempID) throws RemoteException;
	int whosTurn() throws RemoteException;
	
	
	

}
