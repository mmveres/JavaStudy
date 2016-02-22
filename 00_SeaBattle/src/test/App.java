package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import entities.ShipCell;
import entities.ShipEntity;
import entities.ShipLayout;
import entities.ShipType;
import logic.BattleField;
import logic.BattleFieldController;

public class App {
	public static void main(String[] args) {
		BattleField bf = new BattleField();
		BattleFieldController bc = new BattleFieldController(bf);
//		b.printBattlefield();
//		b.addShip(new ShipEntity(new ShipCell(6, 1), ShipLayout.Horizontal, ShipType.SUBMARINE));
//		b.addShip(new ShipEntity(new ShipCell(8, 2), ShipLayout.Horizontal, ShipType.SUBMARINE));
		bc.generateFleet(false);
		bc.printBattlefield();
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String temp=null;
		try {

			String []input=null;
			while(temp==null||!temp.equals("EXIT")){
				temp = keyboard.readLine();
				System.out.println("");
				input=temp.split(",");
				int x = Integer.parseInt(input[0]);
				int y = Integer.parseInt(input[1]);
				System.out.println(bc.shootCell(new ShipCell(x, y)));
				bc.printBattlefield();
				System.out.println(bf.getHealth());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	}

}
