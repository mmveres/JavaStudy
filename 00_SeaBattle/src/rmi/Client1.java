package rmi;

import entities.User;

public class Client1 {
	public static void main(String[] args) {
		RMIClient client = new RMIClient(new User(1,"Vasya"));
		client.start();
	}
}
