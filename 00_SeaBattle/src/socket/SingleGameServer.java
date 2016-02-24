package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;


import entities.User;

public class SingleGameServer implements Runnable {
	private static int counter=0;
	private int id=counter++;
	private volatile boolean stop;
	private Socket socket;
	private MainServer mainServer;
	private User user;
	private BufferedReader in;
	private PrintWriter out;

	public SingleGameServer(MainServer mainServer, Socket socket) throws IOException{
		this.mainServer=mainServer;
		this.socket=socket;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
	}

	@Override
	public void run() {
		System.out.println("Thread server " + id + " started.");
		try {
			while (!stop) {
				String str = in.readLine();
				if (str == null) {
					stop = true;
				} else {
					parseMessage(str);
				}
			}

		} catch (IOException e) {
			System.err.println("IO Exception");
		} finally {
			try {
				System.out.println("closing... " + id);
				socket.close();
				mainServer.removeSingleGameServer(this);
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (IOException e) {
				System.err.println("Socket not closed");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void parseMessage(String str) {
		// TODO Auto-generated method stub
		
	}

	public void sendMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

}
