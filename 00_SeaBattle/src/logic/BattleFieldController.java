package logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import entities.FieldCell;
import entities.Message;
import entities.Ship;
import entities.ShipCell;
import entities.ShipEntity;
import entities.ShipLayout;
import entities.ShipType;

public class BattleFieldController {

	private BattleField battleField;
	private FieldCell[][] battleArray;
	private List<Ship> ships = new LinkedList<>();

	public BattleFieldController(BattleField battleField) {
		this.battleField = battleField;
		if (battleField != null)
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

	public Message shootCell(ShipCell shipCell) {
		int x = shipCell.getX() - 1;
		int y = shipCell.getY() - 1;
		Message message = new Message(x + 1, y + 1);
		battleArray[x][y].setHit(true);
		if (battleArray[x][y].isShip()) {
			for (Ship ship : ships) {
				if (ship.isShip(shipCell, true)) {
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
						if (types[i] == ShipType.SUBMARINE) {
							layout = ShipLayout.Horizontal;
						} else {
							layout = layouts[(int) (Math.random() * 2)];
						}
						int x = rn.nextInt(BattleField.FIELD_SIZE-1) + 1;
						int y = rn.nextInt(BattleField.FIELD_SIZE-1) + 1;
						System.out.println("" + x + "," + y);
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
