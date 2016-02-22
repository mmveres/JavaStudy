package entities;

import java.io.Serializable;

public class ShipCell implements Serializable{
	private int x;
	private int y;
	private boolean hit;

	public ShipCell(int x, int y) {
		if(x<1||y<1||x>10||y>10)throw new IllegalArgumentException("Wrong argument(s). Coordinate value should be within range 1... 10");
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if(x<1||x>10)throw new IllegalArgumentException("Wrong argument(s). value should be withit range 1... 10");
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if(y<1||y>10)throw new IllegalArgumentException("Wrong argument(s). value should be withit range 1... 10");
		this.y = y;
	}

	public boolean isHit() {
		return hit;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof ShipCell))
			return false;
		if (x != ((ShipCell) obj).getX())
			return false;
		if (y != ((ShipCell) obj).getY())
			return false;
		return true;
	}
}
