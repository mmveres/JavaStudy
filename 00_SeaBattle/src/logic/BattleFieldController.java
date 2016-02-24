package logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import entities.cells.CoordinateCell;
import entities.cells.FieldCell;
import entities.cells.ShipCell;
import entities.cells.ShotResult;
import entities.ships.Ship;
import entities.ships.ShipEntity;
import entities.ships.ShipLayout;
import entities.ships.ShipType;

/**
 * Class responsible for basic interactions with <a href=".../logic/BattleField.html">Battlefield<a/> object:<br>
 * - automatic random fleet generation <br>
 * - generating shot replies (cell status after being shot - is it ship, is it hit, is ship still operational)<br>
 * - generating console output for current Battlefield status<br>
 * - adding and removing single ship<br>
 * Class can interact with externally generated battlefield in condition ships  have valid location.
 * 
 * @author d2e
 *
 */
public class BattleFieldController {

	private BattleField battleField;
	private FieldCell[][] battleArray;
	private List<Ship> ships = new LinkedList<>();

	public BattleFieldController(BattleField battleField) {
		if(battleField==null)throw new IllegalArgumentException("Nullable argument provided for controller!");
		this.battleField = battleField;
		if (battleField.getFieldArray() != null)
			battleArray = battleField.getFieldArray();

	}

	public BattleField getBattleField() {
		return battleField;
	}

	public void setBattleField(BattleField battleField) {
		this.battleField = battleField;
		if (battleField != null) {
			battleArray = battleField.getFieldArray();
			ships = parseFieldArray(battleField.getFieldArray());
		}

	}

	
	 /**
     * A method which adds a ship and "dead zone" around it to battlefield only in case if provided
     * <a href=".../entities/ships/Ship.html">Ship</a> object meets placing restrictions:<br>
     * -ship type amount on field is within restricted qty<br>
     * -all <a href=".../entities/cells/ShipCell.html">ShipCells</a> are within field<br>
     * - Ship does not cross another ship already placed or "dead zone" around ships 
     *
     * @param  Ship
     *         A ship object as described in <a href=".../entities/ships/Ship.html">Ship</a>
     *         syntax.
     *
     * @throws  NullPointerException
     *          If the <tt>Ship</tt> is <tt>null</tt>
     *
     * @return  Boolean <tt>true</tt>  if ship is added, otherwise false;
     */
	
	public boolean addShip(Ship ship) {
		if (extendsAllowedQty(ship))
			return false;
		if (isPlaceable(ship)) {
			ships.add(ship);
			setOnField(ship, true);
			setHalo(ship, false);
			battleField.setCurrentHealth(battleField.getCurrentHealth() + ship.getType().getLength());
			return true;
		}

		return false;

	}

	public boolean removeShip(Ship ship) {
		if (!ships.remove(ship))
			return false;
		setOnField(ship, false);
		setHalo(ship, true);
		battleField.setCurrentHealth(battleField.getCurrentHealth() - ship.getType().getLength());
		return true;

	}

	public List<Ship> getShips() {
		return ships;

	}

	public ShotResult shootCell(CoordinateCell shotCell) {
		int x = shotCell.getX() - 1;
		int y = shotCell.getY() - 1;
		ShotResult message = new ShotResult(x + 1, y + 1);
		battleArray[x][y].setHit(true);
		if (battleArray[x][y].isShip()) {
			for (Ship ship : ships) {
				if (ship.isShip(shotCell, true)) {
					message.setHit(true);
					battleField.setCurrentHealth(battleField.getCurrentHealth() - 1);
					;
					message.setAlive(ship.isAlive());
				}
			}
		}

		return message;
	}

	public void printBattlefield() {
		int counter = 1;
		System.out.println("    [A][B][C][D][E][F][G][I][J][K]");
		for (int i = 0; i < battleArray[0].length; i++) {
			System.out.printf("[%2d]", counter++);
			for (int j = 0; j < battleArray.length; j++) {
				System.out.print(getMarker(battleArray, j, i));
			}
			System.out.println();
		}
	}

	public void generateFleet(boolean clever) {
		ShipLayout[] layouts = ShipLayout.values();
		ShipType[] types = ShipType.values();
		Random rn = new Random();
		if (clever) {
		} else {
			for (int i = types.length - 1; i >= 0; i--) {
				for (int j = 0; j < types[i].getMaxQty(); j++) {
					boolean added = false;
					while (!added) {
						ShipLayout layout = null;
						int maxX = BattleField.FIELD_SIZE;
						int maxY = BattleField.FIELD_SIZE;
						if (types[i] == ShipType.SUBMARINE) {
							layout = ShipLayout.Horizontal;
						} else {
							layout = layouts[(int) (Math.random() * layouts.length)];
							switch (layout) {
							case Horizontal:
								maxX = maxX + 1 - types[i].getLength();
								break;
							case Vertical:
								maxY = maxY + 1 - types[i].getLength();
								break;
							}
						}
						int x = rn.nextInt(maxX) + 1;
						int y = rn.nextInt(maxY) + 1;
						do {
						} while (false);
//						System.out.println("" + x + "," + y);
						added = addShip(new ShipEntity(new ShipCell(x, y), layout, types[i]));
					}
				}

			}

		}
	}

	private void setOnField(Ship ship, boolean isShip) {
		for (ShipCell shipCell : ship.getPosition()) {
			battleArray[shipCell.getX() - 1][shipCell.getY() - 1].setShip(isShip);
		}

	}

	private void setHalo(Ship ship, boolean isPlaceable) {
		int minX = ship.getPosition()[0].getX() - 2;
		int minY = ship.getPosition()[0].getY() - 2;
		int maxX = ship.getPosition()[ship.getType().getLength() - 1].getX() + 1;
		int maxY = ship.getPosition()[ship.getType().getLength() - 1].getY() + 1;
		for (int j = minY; j < maxY; j++) {
			for (int i = minX; i < maxX; i++) {
				if (i > -1 && j > -1 && i < BattleField.FIELD_SIZE && j < BattleField.FIELD_SIZE) {
					battleArray[i][j].setPlaceable(isPlaceable);
				}

			}
		}

	}

	private boolean isPlaceable(Ship ship) {
		ShipCell[] cells = ship.getPosition();
		for (ShipCell shipCell : cells) {
			if (shipCell.getX() > BattleField.FIELD_SIZE)
				return false;
			if (shipCell.getY() > BattleField.FIELD_SIZE)
				return false;
			if (!battleArray[shipCell.getX() - 1][shipCell.getY() - 1].isPlaceable())
				return false;
		}
		return true;
	}

	private boolean extendsAllowedQty(Ship ship) {
		ShipType type = ship.getType();
		int counter = 0;
		for (Ship s : ships) {
			if (s.getType() == type)
				counter++;
		}
		if (++counter > type.getMaxQty())
			return true;
		return false;
	}

	private String getMarker(FieldCell[][] battlefield, int x, int y) {
		if (battlefield[x][y].isShip()) {
			if (battlefield[x][y].isHit())
				return "[X]";
			return "[S]";
		}
		// if (!fieldCell.isPlaceable())
		// return "[X]";
		if (battlefield[x][y].isHit())
			return "[*]";
		return "[ ]";

	}

	private List<Ship> parseFieldArray(FieldCell[][] fieldArray) {
		List<Ship> newShips = new LinkedList<>();
		ShipLayout layout = null;
		ShipType type = null;
		for (int i = 0; i < fieldArray.length; i++) {
			for (int j = 0; j < fieldArray.length; j++) {
				if (fieldArray[j][i].isShip()) {
					ShipCell newShipCell = new ShipCell(j + 1, i + 1);
					if (newShips.size() > 0) {
						if (shipInList(newShips, newShipCell))
							continue;
					}
					int counter = 2;
					if ((j + 1) < BattleField.FIELD_SIZE && fieldArray[j + 1][i].isShip()) {
						layout = ShipLayout.Horizontal;
						while ((j + counter) < BattleField.FIELD_SIZE && fieldArray[j + counter][i].isShip()) {
							counter++;
						}
						type = ShipType.getTypeByLength(counter);
						newShips.add(new ShipEntity(newShipCell, layout, type));
					} else if ((i + 1) < BattleField.FIELD_SIZE && fieldArray[j][i + 1].isShip()) {
						layout = ShipLayout.Vertical;
						while ((i + counter) < BattleField.FIELD_SIZE && fieldArray[j][i + counter].isShip()) {
							counter++;
						}
						type = ShipType.getTypeByLength(counter);
						newShips.add(new ShipEntity(newShipCell, layout, type));
					} else {
						newShips.add(new ShipEntity(newShipCell, ShipLayout.Horizontal, ShipType.SUBMARINE));

					}
				}
			}
		}

		return newShips;
	}

	private boolean shipInList(List<Ship> shipList, ShipCell shipCell) {
		for (Ship ship : shipList) {
			if (ship.isShip(shipCell, false))
				return true;
		}
		return false;
	}

}
