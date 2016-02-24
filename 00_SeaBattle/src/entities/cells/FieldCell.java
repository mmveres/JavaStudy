package entities.cells;

import java.io.Serializable;

public class FieldCell implements Serializable{
	private boolean ship;
	private boolean hit;
	private boolean placeable=true;
	

	
	public boolean isShip() {
		return ship;
	}
	public void setShip(boolean ship) {
		this.ship = ship;
	}
	public boolean isHit() {
		return hit;
	}
	public void setHit(boolean hit) {
		this.hit = hit;
	}
	public boolean isPlaceable() {
		return placeable;
	}
	public void setPlaceable(boolean placeable) {
		this.placeable = placeable;
	}
	

}
