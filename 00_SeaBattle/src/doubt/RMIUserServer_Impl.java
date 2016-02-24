package doubt;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import entities.User;

public class RMIUserServer_Impl implements Runnable {
	private Set<User> users = new HashSet<>();

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public void addUser(User user) {
		synchronized (users) {
			users.add(user);
		}

	}

	public void removeUser(User user) {
		synchronized (users) {
			users.remove(user);
		}
	}

	public Set<User> getUsers() {
		Set<User> newUserSet = new HashSet<>();
		synchronized (users) {
			for (User user : users) {
				newUserSet.add(new User(user.getIdUser(), user.getName()));

			}
		}
		return newUserSet;
	}

}
