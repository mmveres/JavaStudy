package entities.cells;

import java.io.Serializable;


public class CoordinateCell implements Serializable{
	public static final int FIELD_SIZE=10;
	private int x;
	private int y;

	public CoordinateCell(int x, int y) {
		if(x<1||y<1||x>FIELD_SIZE||y>FIELD_SIZE)throw new IllegalArgumentException("Wrong argument(s). Coordinate value should be within range 1... 10");
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


	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof CoordinateCell))
			return false;
		if (x != ((CoordinateCell) obj).getX())
			return false;
		if (y != ((CoordinateCell) obj).getY())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cell [" + x + "," + y + "]";
	}
	
	
}
