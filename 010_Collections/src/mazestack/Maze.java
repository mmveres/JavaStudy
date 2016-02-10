package mazestack;

import java.util.concurrent.TimeUnit;

public class Maze {
	private Cell[][] maze_array;
	private int sizeX, sizeY;
	private int counter;
	private CellStack cs = new CellStack();
	private Cell currCell;
	private Cell prevCell;
	private Cell[] neighbours = new Cell[4];
	private long start;
	private long stop;

	public Maze(int sizeX, int sizeY) {

		this.sizeX = sizeX * 2 + 1;
		this.sizeY = sizeY * 2 + 1;
		counter = sizeX * sizeY;
		maze_array = new Cell[this.sizeX][this.sizeY];
		buildMaze();
	}

	private void buildMaze() {
		start=System.nanoTime();
		initWalls();
		setEntrance();
		buildWay();
		setExit();
		stop=System.nanoTime();

	}

	private void setExit() {
		// define random exit
		currCell = new Cell(sizeX - 1, (1 + (int) (Math.random() * (sizeY - 1) / 2) * 2), false);
		currCell.setVisited(true);
		maze_array[currCell.getX()][currCell.getY()] = currCell;

	}

	private void buildWay() {
		// first valid cell is near entrance and defined in setEntrance()
		// if there are yet unvisited cells which are within maze
		while (counter > 0) {
			// get valid cells to visit around current
			int vn = getValidNeighbours(currCell, 2);
			// if such exist
			if (vn > 0) {
				// save current cell
				prevCell = currCell;
				// randomly select new current cell from available ones
				currCell = neighbours[(int) (Math.random() * vn)];
				currCell.setVisited(true);
				// delete wall between old and new cell
				destroyWall(prevCell, currCell);
				// put current cell to stack
				cs.push(currCell);
				//
				counter--;
			} else {
				currCell = cs.pop();

			}

		}
	}

	private void destroyWall(Cell c1, Cell c2) {
		//
		int x = c1.getX() + ((c2.getX() - c1.getX()) / 2);
		int y = c1.getY() + ((c2.getY() - c1.getY()) / 2);
		maze_array[x][y].setClosed(false);

	}

	public int getValidNeighbours(Cell cs, int step) {
		// valid neighbor cells are:
		// they are within maze(compare coord to sizeX/Y),
		// they are not in "wall" column/row (coord+step),
		// they are not visited yet (isVisited=FALSE)
		int qty = 0;
		int cX = cs.getX();
		int cY = cs.getY();

		// right neighbor ok?
		if (cX + step < sizeX && !maze_array[cX + step][cY].isVisited() && !maze_array[cX + step][cY].isClosed()) {
			neighbours[qty++] = maze_array[cX + step][cY];
		}
		// down neighbour ok?
		if (cY + step < sizeY && !maze_array[cX][cY + step].isVisited() && !maze_array[cX][cY + step].isClosed()) {
			neighbours[qty++] = maze_array[cX][cY + step];
		}
		// left neighbour ok?
		if (cX - step > 0 && !maze_array[cX - step][cY].isVisited() && !maze_array[cX - step][cY].isClosed()) {
			neighbours[qty++] = maze_array[cX - step][cY];
		}
		// up neighbour ok?
		if (cY - step > 0 && !maze_array[cX][cY - step].isVisited() && !maze_array[cX][cY-step].isClosed()) {
			neighbours[qty++] = maze_array[cX][cY - step];
		}

		return qty;

	}

	private void setEntrance() {
		// define random entrance
		currCell = new Cell(0, (1 + (int) (Math.random() * (sizeY - 1) / 2) * 2), false);
		maze_array[currCell.getX()][currCell.getY()] = currCell;
		// define next after entrance
		currCell = maze_array[currCell.getX() + 1][currCell.getY()];
		currCell.setVisited(true);
		cs.push(currCell);
		counter--;

	}

	private void initWalls() {

		for (int x = 0; x < sizeX; x++) {
			for (int y = 0; y < sizeY; y++) {
				// all cells with even x,y - are walls
				if (x % 2 == 0 || y % 2 == 0) {
					maze_array[x][y] = new Cell(x, y, true);
				} else {
					maze_array[x][y] = new Cell(x, y, false);
				}
			}
		}
	}

	public Cell[][] getMaze_array() {
		return maze_array;
	}

	public Cell getCell(int x, int y) {
		return maze_array[x][y];
	}

	public void dispayMaze() {
		for (int y = 0; y < sizeY; y++) {

			for (int x = 0; x < sizeX; x++) {
				if (maze_array[x][y].isClosed()) {
					System.out.print("[X]");
				} else if (maze_array[x][y].isInPath()) {
					System.out.print(" * ");
				} else {
					System.out.print("   ");
				}

			}
			System.out.println("");
		}
		System.out.println("time taken: " + ((stop-start)/1000)+" microseconds \n");
	}

	public void solveMaze() {
		start=System.nanoTime();
		resetVisited();
		findEntrance();
		findWay();
		stop=System.nanoTime();
	}

	private void findWay() {
		// we got entrance cell from findEntrance()
		// until we are not at right side of maze
		while (currCell.getX() < sizeX - 1) {

			// get valid cells to visit around current
			int vn = getValidNeighbours(currCell, 1);
//			System.out.println("for "+currCell+" valid nbrs qty: " + vn);
			// if such exist
			if (vn > 0) {

				// put current cell to stack
				cs.push(currCell);
				// prefer right-hand path
				currCell = neighbours[0];
				currCell.setInPath(true);
				currCell.setVisited(true);
//				System.out.println("selected: " + currCell);

			} else {
				// if not - mark current out of path
				currCell.setInPath(false);
				//make step back
				currCell = cs.pop();
//				System.out.println("no valid nbrs, pop back to: " + currCell);
			}
//			dispayMaze();
		}
		currCell.setVisited(true);
		currCell.setInPath(true);
	}

	private void findEntrance() {
		counter = 0;
		// assume single entrance always on left end and exit on right
		// so we going Y axis checking which cell is not wall
		do {
			currCell = maze_array[0][counter++];
		} while (currCell.isClosed());
		System.out.println("entrance: "+currCell);
		currCell.setInPath(true);
		currCell.setVisited(true);

	}

	private void resetVisited() {
		for (int x = 0; x < sizeX; x++) {
			for (int y = 0; y < sizeY; y++) {
				maze_array[x][y].setVisited(false);
			}
		}
//		cs.clear();
	}
	
	public int getPathLength() {
		return cs.getSize();
	}
}
