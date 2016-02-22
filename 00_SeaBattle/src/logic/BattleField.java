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

public class BattleField {
	public static final int FIELD_SIZE = 10;
	public static final int MAX_HEALTH=20;

	private FieldCell[][] fieldArray = new FieldCell[FIELD_SIZE][FIELD_SIZE];
	private int currentHealth;
	
	public FieldCell[][] getFieldArray() {
		return fieldArray;
	}
	
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	public int getCurrentHealth() {
		return currentHealth;
	}

	public boolean isFleetAlive() {
		return currentHealth!=0;
	}
	
	public float getHealth(){
		return ((float)currentHealth)/((float)MAX_HEALTH);
	}
	
	
	public BattleField() {
		for (int i = 0; i < fieldArray.length; i++) {
			for (int j = 0; j < fieldArray.length; j++) {
				fieldArray[j][i] = new FieldCell();
			}
		}
	}

	

}
