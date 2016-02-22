package logic;

import entities.User;

public class Game implements Runnable{

	private User user01;
	private User user02;
	private BattleField battleField01;
	private BattleField battleField02;
	private User winner;
	private volatile boolean stop;
	
	
	public Game() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void run() {
		if(battleField01==null||battleField02==null||user01==null||user02==null)return;
		while(!stop){
			
		}
		
	}
	
	
	
	
	
}
