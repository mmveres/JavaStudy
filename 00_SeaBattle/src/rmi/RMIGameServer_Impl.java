package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Random;

import javax.xml.transform.Result;

import com.sun.javafx.collections.MappingChange.Map;

import entities.User;
import entities.cells.CoordinateCell;
import entities.cells.ShipCell;
import entities.cells.ShotResult;
import logic.BattleField;

public class RMIGameServer_Impl extends UnicastRemoteObject implements RMIGameServer {
	public static final int MAX_SLOTS = 2;
	private int freeSlots = MAX_SLOTS;
	private User[] users = new User[MAX_SLOTS];
	private long[] keys = new long[MAX_SLOTS];
	private boolean stop;
	private boolean first=true;
	private boolean firstMove = true;
	private int idUserforMove = -1;
	private int idStopper = -1;
	private int currIndex=-1;
	private CoordinateCell cell;
	private ShotResult result;
	private boolean ready;

	public RMIGameServer_Impl() throws RemoteException {
	}

	
	/**
	 * 
	 */
	
	@Override
	public synchronized long addUser(User user) throws RemoteException {
		if (freeSlots > 0) {
			freeSlots--;
			users[freeSlots] = user;
			keys[freeSlots] = System.currentTimeMillis() + user.hashCode() * 13;
			System.out.println("Added user " + users[freeSlots].getName() + " " + keys[freeSlots]);
			if (freeSlots==0)ready=true;
			return keys[freeSlots];
			
		}
		return -1;
	}


	@Override
	public boolean putShot(CoordinateCell cell, long tempID) throws RemoteException {
		if(stop||tempID!=keys[currIndex]) return false;
		this.cell=cell;
		System.out.println("User " + users[currIndex]+ " put shot at " + this.cell);
		changeUser();
		return true;
		
	}


	private void changeUser() {
		currIndex=1-currIndex;
		idUserforMove=users[currIndex].getIdUser();
		System.out.println("now "+ users[currIndex]+ " move");
	}


	@Override
	public CoordinateCell getShot(long tempID) throws RemoteException {
		if(stop||tempID!=keys[currIndex]) return null;
		CoordinateCell temp=cell;
		cell=null;
		System.out.println("User " + users[currIndex]+ " taking shot at " + temp);
		return temp;
	}


	@Override
	public boolean putResult(ShotResult result, long tempID) throws RemoteException {
		if(stop||tempID!=keys[currIndex]) return false;
		this.result=result;
//		changeUser();
		return true;
	}


	@Override
	public ShotResult getResult(long tempID) throws RemoteException {
		if(stop||tempID!=keys[currIndex]) return null;
		ShotResult temp = result;
		result=null;
		return temp;
	}


	@Override
	public boolean isAlive() throws RemoteException {
		return !stop;
	}


	@Override
	public synchronized void stop(long tempID) throws RemoteException {
		for (int i = 0; i < keys.length; i++) {
			if(keys[i]==tempID){
				idStopper=i;
				stop=true;				
				idUserforMove=-1;
			}
		}
	
	}


	@Override
	public int whosTurn() {
		if(!ready) return -1;
		if(first){
			currIndex=(int)(Math.random()*users.length);
			idUserforMove=users[currIndex].getIdUser();
			first=false;
			System.out.println("" + users[currIndex]+" moves First");
		}
		return idUserforMove;
	}





}
