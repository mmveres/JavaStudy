package ex_simplier;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerLocal {
	public static void main(String[] args) {
		try {
			// Создаю службу реестра RMI
			// на локальном хосте, прослушивающую порт 1099
			Registry r = LocateRegistry.createRegistry(1099);
			// Создаю серверный объект
			RMIServerImpl server = new RMIServerImpl();
			// Регистрирую его в реестре
			r.rebind("SayHello", server);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
