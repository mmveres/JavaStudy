package jabber.app;

import jabber.client.JabberClient;
import jabber.clientGUI.LoginGUI;

public class AppClient {
	public static void main(String[] args) {
		JabberClient jc = new JabberClient();
		LoginGUI loginGUI = new LoginGUI();
		jc.setJabberClientListener(loginGUI);
		loginGUI.setJabberClient(jc);
		loginGUI.start();
		jc.start();
		
	}
	

}
