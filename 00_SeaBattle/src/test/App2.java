package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entities.Ship;
import entities.ShipCell;
import entities.ShipEntity;
import entities.ShipLayout;
import entities.ShipType;
import logic.BattleField;
import logic.BattleFieldController;

public class App2 {
	public static void main(String[] args) {
		List<Ship> ships=null;
		BattleField bf = new BattleField();
		BattleFieldController bc1 = new BattleFieldController(bf);
		BattleFieldController bc2 = new BattleFieldController(null);
		bc1.generateFleet(false);
		bc1.printBattlefield();
		System.out.println("---------------------------");
		ships=bc1.getShips();
		for (Ship ship : ships) {
			System.out.println(ship);
		}
		System.out.println(bf==bc1.getBattleField());
		bc2.setBattleField(bf);
		ships=bc2.getShips();
		System.out.println("---------------------------");
		bc2.printBattlefield();	
		Collections.sort(ships, new Comparator<Ship>() {

			@Override
			public int compare(Ship o1, Ship o2) {
				return o2.getType().getLength()-o1.getType().getLength();
			}
		});
		System.out.println("---------------------------");
		for (Ship ship : ships) {
			System.out.println(ship);
		}
		System.out.println("---------------------------");
	}

}
