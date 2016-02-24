package doubt;

import entities.User;

public class Client2 {
	public static void main(String[] args) {
		RMIClient client = new RMIClient(new User(1,"Petya"));
		client.start();
	}
}
