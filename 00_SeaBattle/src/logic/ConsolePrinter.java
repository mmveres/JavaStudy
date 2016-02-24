package logic;

import entities.cells.FieldCell;

public class ConsolePrinter {
	private BattleField myBattleField, enemyBattlefield;
	private FieldCell [][]myArray;
	private FieldCell [][]enemyArray;
	private int fieldSize=10;

	public ConsolePrinter(BattleField myBattleField, BattleField enemyBattlefield) {
		this.myBattleField = myBattleField;
		myArray=myBattleField.getFieldArray();
		this.enemyBattlefield = enemyBattlefield;
		enemyArray=enemyBattlefield.getFieldArray();
	}
	
	public void printBattlefield() {
		int counter = 1;
		System.out.println("ME: [A][B][C][D][E][F][G][I][J][K]   ENEMY:[A][B][C][D][E][F][G][I][J][K]");
		for (int i = 0; i < fieldSize; i++) {
			System.out.printf("[%2d]", counter++);
			for (int j = 0; j < fieldSize; j++) {
				System.out.print(getMyMarker(myArray, j, i));
			}
			System.out.printf("     [%2d]", counter);
			for (int j = 0; j < fieldSize; j++) {
				System.out.print(getEnemyMarker(enemyArray, j, i));
			}
			System.out.println();
		}
	}
	
	private String getMyMarker(FieldCell[][] battlefield, int x, int y) {
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
	
	private String getEnemyMarker(FieldCell[][] battlefield, int x, int y) {

		if (battlefield[x][y].isShip()) return "[X]";
		if (battlefield[x][y].isHit())	return "[*]";
		if (battlefield[x][y].isPlaceable()) return "[?]";
		return "[ ]";

	}

}
