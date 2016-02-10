package punish_bear_task;

public class Forest {
	private boolean [][]forest;
	private int x,y;
	private boolean found;

	
	public synchronized boolean isBearFound() {
		return found;		
	}
	
	public void serBearFound(boolean found) {
		this.found = found;
	}
	
	public Forest(int sizeX, int sizeY) {
		forest=new boolean[sizeY][sizeX];
		x=(int)(Math.random()*sizeX);
		y=(int)(Math.random()*sizeY);
		forest[y][x]=true;
		
	}
	
	
	public boolean[][] getForest() {
		return forest;
	}

	@Override
	public String toString() {
		return "Forest with bear at [x=" + x + ", y=" + y + "]";
	}
	
	

}
