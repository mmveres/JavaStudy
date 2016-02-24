package test;


import entities.cells.CoordinateCell;
import entities.cells.ShotResult;
import logic.BattleField;
import logic.BattleFieldController;
import logic.ConsolePrinter;
import logic.EnemyFieldController;

public class App3 {
public static void main(String[] args) {
	BattleField me = new BattleField();
	BattleField enemy = new BattleField();
	BattleFieldController bfc = new BattleFieldController(me);
	bfc.generateFleet(false);
	EnemyFieldController efc=new EnemyFieldController(enemy);
	efc.setShot(new CoordinateCell(2, 2));
	efc.setShotResult(new ShotResult(3, 3, false, true));
	efc.setShotResult(new ShotResult(3, 4, true, true));
	ConsolePrinter cp= new ConsolePrinter(me, enemy);
	cp.printBattlefield();

}
}
