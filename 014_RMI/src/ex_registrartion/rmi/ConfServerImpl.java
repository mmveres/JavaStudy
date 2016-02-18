package ex_registrartion.rmi;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.security.Permission;
import java.util.List;

import ex_registrartion.dao.ParticipantDAO;
import ex_registrartion.entities.Participant;
import ex_simple.MyArrayImpl;

public class ConfServerImpl extends UnicastRemoteObject implements ConfServer{
	private ParticipantDAO partDAO;

	protected ConfServerImpl() throws RemoteException {
		super();
		partDAO=new ParticipantDAO();
	}


	@Override
	public void registerConfParticipant(Participant registrationInfo) throws RemoteException {
		try {
			partDAO.addParticipant(registrationInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Participant> getAllParticipants() throws RemoteException {
		List<Participant> participants=null;
		try {
			participants=partDAO.getAllParticipants();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return participants;
	}

	public static void main(String args[]) {
		ConfServer server;
		try {
			server = new ConfServerImpl();
			Registry registry = LocateRegistry.createRegistry(59001);
			registry.rebind("Array", server);
			System.out.println("Server started!");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
