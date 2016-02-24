package entities.ships;

import entities.cells.CoordinateCell;
import entities.cells.ShipCell;

public interface Ship {

	boolean isAlive();
	boolean isShip(CoordinateCell cell, boolean markHit);
	ShipType getType();
	ShipCell []getPosition();
}
