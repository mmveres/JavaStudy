package entities.cells;

import java.io.Serializable;

public class ShotResult extends ShipCell implements Serializable{
	private boolean alive=true;
	
	
	
	public ShotResult(int x, int y) {
		super(x, y);
		
	}

	public ShotResult(int x, int y, boolean isHit, boolean isAlive) {
		super(x, y);
		super.setHit(isHit);
		alive=isAlive;
		
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
