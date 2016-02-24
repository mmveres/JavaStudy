package rmi;

import entities.User;

public class Client2 {
	public static void main(String[] args) {
		RMIClient client = new RMIClient(new User(2,"Petya"));
		client.start();
	}
}
