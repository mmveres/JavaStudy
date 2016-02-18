package ex_registrartion.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import ex_registrartion.entities.Participant;

public interface ConfServer extends Remote{
	void registerConfParticipant(Participant registrationInfo) throws RemoteException;
	List<Participant> getAllParticipants()  throws RemoteException;

}
