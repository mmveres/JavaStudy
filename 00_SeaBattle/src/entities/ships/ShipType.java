package entities.ships;

public enum ShipType {

	
	SUBMARINE(1,4), DESTROYER(2,3), CRUISER(3,2), BATTLESHIP(4,1);
	
	private int length; //ship length
	private int maxQty; //max quantity per game field

	private ShipType(int length, int maxQty) {
		this.maxQty=maxQty;
		this.length=length;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getMaxQty() {
		return maxQty;
	}
	
	public static ShipType getTypeByLength(int length){
		for (ShipType type : values()) {
			if(type.getLength()==length) return type;
		}
		return null;
	}
}
