package rmi;

import entities.User;

public class Client3 {
	public static void main(String[] args) {
		RMIClient client = new RMIClient(new User(3,"John"));
		client.start();
	}
}
