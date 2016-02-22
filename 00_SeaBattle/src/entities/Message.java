package entities;

import java.io.Serializable;

public class Message extends ShipCell implements Serializable{
	private boolean alive=true;
	
	
	public Message(int x, int y) {
		super(x, y);
		
	}


	public boolean isAlive() {
		return alive;
	}


	public void setAlive(boolean alive) {
		this.alive = alive;
	}


	@Override
	public String toString() {
		return "Message [x=" + getX() + ", x=" + getY() + ", hit=" + isHit() +", alive=" + alive + "]";
	}


	
	
}
