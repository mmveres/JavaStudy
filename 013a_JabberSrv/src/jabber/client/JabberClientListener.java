package jabber.client;

import java.util.List;

import jabber.entities.User;

public interface JabberClientListener {
	void statusChanged();
	void registerOK();
	void loginOK();
	void connectOK();
	void addUser(int id, String name);
	void removeUser(int id, String name);
	void userListUpdated(List<User> users);
	void newMessageArrived(int parseInt, String string);
}
