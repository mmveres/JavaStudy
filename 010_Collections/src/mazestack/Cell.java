package mazestack;

public class Cell {
	private int x,y;
	private boolean visited;
	private boolean closed;
	private boolean inPath;

	
	
	
	
	public boolean isInPath() {
		return inPath;
	}



	public void setInPath(boolean inPath) {
		this.inPath = inPath;
	}



	public Cell(int x, int y, boolean closed) {
		this.x = x;
		this.y = y;
		this.closed = closed;
	}



	public Cell(boolean closed) {
		this.closed = closed;
	}

	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}


	@Override
	public String toString() {
		return "Cell [" + x + "," + y + "]";
	}


	
	

}
