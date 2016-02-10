package punish_bear_task;

public class Hive implements Runnable{
	Forest forest;
	private int sizeY;
	private int counter;
	private int beesNum;
	private int engagedBees;
	private Bees []bees;
	
	
	
	public Hive(int beesNum, Forest forest) {
		this.forest=forest;
		this.beesNum=beesNum;
		sizeY=forest.getForest()[0].length;
		bees = new Bees[beesNum];
		for (int i = 0; i < bees.length; i++) {
			bees[i]=new Bees(forest);
		}
		new Thread(this).start();
	}

	@Override
	public void run() {
		while(!forest.isBearFound()&&counter<sizeY){
			int i =getFreeGroupIndex();
			if(i>-1){
				bees[i].setAtHome(false);
				bees[i].setRow(counter++);
				new Thread(bees[i]).start();;
				
			}
			
			
		}
		
	}
	
	private int getFreeGroupIndex(){
		int index=-1;
		for (int i = 0; i < bees.length; i++) {
			if(bees[i].isAtHome()){
				index=i;
				break;
			}
			
		}
		return index;
	}

}
