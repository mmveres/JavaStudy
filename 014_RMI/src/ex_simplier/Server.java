package ex_simplier;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Server {
	public static void main(String[] args) {
		try {
			// Создаю серверный объект
			RMIServerImpl server = new RMIServerImpl();
			// Регистрирую его в реестре
			Naming.rebind("//127.0.0.1/SayHello", server);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
