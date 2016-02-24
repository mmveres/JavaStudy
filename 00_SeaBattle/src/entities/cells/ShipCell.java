package entities.cells;

public class ShipCell extends CoordinateCell {
	private boolean hit;	

	public ShipCell(int x, int y) {
		super(x, y);
	}

	public boolean isHit() {
		return hit;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}



	
}
