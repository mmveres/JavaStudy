package entities;

public interface Ship {

	boolean isAlive();
	boolean isShip(ShipCell cell, boolean markHit);
	ShipType getType();
	ShipCell []getPosition();
}
