package logic;

import entities.cells.CoordinateCell;
import entities.cells.FieldCell;
import entities.cells.ShotResult;

public class EnemyFieldController {
	private BattleField battleField;
	private FieldCell[][] battleArray;
	
	
	public EnemyFieldController(BattleField battleField) {
		if (battleField == null)
			throw new IllegalArgumentException("Nullable argument provided for controller!");
		this.battleField = battleField;
		if (battleField.getFieldArray() != null)
			battleArray = battleField.getFieldArray();
		clearPlacable(battleArray);
	}

	public BattleField getBattleField() {
		return battleField;
	}
	
	public void setShot(CoordinateCell shot){
		if(shot.getX()>battleField.FIELD_SIZE||shot.getX()<1) return;
		if(shot.getY()>battleField.FIELD_SIZE||shot.getY()<1) return;
		battleArray[shot.getX()-1][shot.getY()-1].setPlaceable(true);
	}
	
	public void setShotResult(ShotResult shotResult){
		if(shotResult.getX()>battleField.FIELD_SIZE||shotResult.getX()<1) return;
		if(shotResult.getY()>battleField.FIELD_SIZE||shotResult.getY()<1) return;
		battleArray[shotResult.getX()-1][shotResult.getY()-1].setShip(shotResult.isHit());
		battleArray[shotResult.getX()-1][shotResult.getY()-1].setHit(true);
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

	private void clearPlacable(FieldCell[][] btArray) {
		for (int i = 0; i < btArray[0].length; i++) {
			for (int j = 0; j < btArray.length; j++) {
				btArray[j][i].setPlaceable(false);
			}
		}
		
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
		if (battlefield[x][y].isPlaceable())
			return "[?]";
		return "[ ]";

	}

}
