package doubt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

import entities.User;
import entities.cells.CoordinateCell;
import entities.cells.ShipCell;
import entities.cells.ShotResult;
import logic.BattleField;

public class RMIGameServer_Impl extends UnicastRemoteObject implements RMIGameServer {
	public static final int MAX_SLOTS = 2;
	private int freeSlots = MAX_SLOTS;
	private User[] users = new User[MAX_SLOTS];
	private ClientConnection[] connections = new ClientConnectionInstance[MAX_SLOTS];
	private boolean stop;
	private boolean firstMove = true;
	private int idUserforMove = 0;

	protected RMIGameServer_Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isGameActive() {
		return !stop;
	}

	private int getIndexById(int id) {
		for (int i = 0; i < users.length; i++) {
			if (users[i].getIdUser() == id)
				return i;
		}
		return -1;
	}

	@Override
	public synchronized ClientConnection getConnection(final User user) {
		if (freeSlots > 0) {
			freeSlots--;
			users[freeSlots] = user;
			connections[freeSlots] = new ClientConnectionInstance(user);
			return connections[freeSlots];

		}
		return null;
	}

}
