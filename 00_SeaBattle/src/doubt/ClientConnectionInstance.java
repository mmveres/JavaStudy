package doubt;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import entities.User;
import entities.cells.CoordinateCell;
import entities.cells.ShotResult;

public class ClientConnectionInstance implements ClientConnection, Serializable{
	final User myUser;

	public ClientConnectionInstance(User user) {
		myUser = user;
	}
	

	
	@Override
	public void putShot(CoordinateCell cell) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ShotResult getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void doStop() {
		new Thread(new Runnable() {
			public void run() {
				while(true){
					System.out.println("Conn for "+ myUser.getName());
					try {
						TimeUnit.MILLISECONDS.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();

		
	}
}
