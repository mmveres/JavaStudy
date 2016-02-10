package mazestack;

import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) {
		System.out.println("");
		final Maze m = new Maze(10, 7);
		


//			SwingUtilities.invokeLater(new Runnable() {
//				
//				@Override
//				public void run() {
//					MazeGUI mg = new MazeGUI(m.getMaze_array());
//					
//				}
//			});
		
		m.dispayMaze();
		m.solveMaze();
		System.out.println(m.getPathLength());
		m.dispayMaze();
		
//		System.out.println(m.getValidNeighbours(m.getCell(1, 3)));
		
		
//		System.out.println();
//	
//		CellStack cs= new CellStack();
//		cs.push(new Cell(1, 3,false));
//		cs.push(new Cell(2, 4,false));
//		cs.push(new Cell(4, 8,false));
//		cs.push(new Cell(3, 7,false));
//		cs.push(new Cell(1, 1,false));
//		while(!cs.isEmpty()){
//			System.out.println(cs.pop());
//		}
//	
//		System.out.println(2%2);
	}
}
