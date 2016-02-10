package mazestack;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class MazeGUI extends JFrame{
	private JPanel mazePanel=new JPanel();
	private JLabel blackBox=new JLabel("[X]");
	private JLabel whiteBox=new JLabel("[ ]");
	
	private int arrXsize,arrYsize;
	
	public MazeGUI(Cell [][]maze_array) {
		if(maze_array==null){
			System.out.println("Empty Maze!");
		}else{
			arrXsize=maze_array.length;
			arrYsize=maze_array[0].length;
			blackBox.setBackground(Color.BLACK);
			whiteBox.setBackground(Color.WHITE);
			mazePanel.setBorder(new TitledBorder("Maze"));
			mazePanel.setLayout(new GridLayout(arrYsize, arrXsize));
			for (int x = 0; x < arrXsize; x++) {
				for (int y = 0; y < arrYsize; y++) {
					if(maze_array[x][y].isClosed()){
						mazePanel.add(blackBox);
					}else{
						mazePanel.add(whiteBox);
					}
				}
				
			}
			add(mazePanel);
			setTitle("GUI");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pack();
			setVisible(true);
			
			
		}
		
	}
	


}
