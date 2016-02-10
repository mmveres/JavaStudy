package figures.gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;


import figures.Figure;
import figures.FigureContainer;

//this class listens to ControlPanel and manages FigurePanel
public class MyPainter extends JFrame implements ControlPanelListener{
	private static final long serialVersionUID = 1300533902430106028L;
	ControlPanel controlPanel=new ControlPanel();
	FigurePanel figurePanelp;
	FigureContainer fc_int;

	public MyPainter(FigureContainer fc) {
		fc_int=fc;
		setLayout(new BorderLayout());
		add(BorderLayout.EAST, controlPanel);
		figurePanelp=new FigurePanel(fc_int.getFigures());
		add(BorderLayout.CENTER, figurePanelp);
//		setLayout(new GridLayout(1, 2));
//		add(new FigurePanel(f));
//		add(new ControlPanel());
		controlPanel.setControlPanelListener(this);
	}

	@Override
	public void generateNewSet() {
		fc_int.generateFigureArray(5);
		figurePanelp.setFigures(fc_int.getFigures());
		figurePanelp.repaint();
		
	}

	@Override
	public void changeColor(Color color) {
		fc_int.setFiguresColor(color);
		figurePanelp.setFigures(fc_int.getFigures());
		figurePanelp.repaint();
		
	}

	@Override
	public void moveUpRq(int step) {
		fc_int.moveUp(step);
		figurePanelp.setFigures(fc_int.getFigures());
		figurePanelp.repaint();
		
		
	}

	@Override
	public void moveDownRq(int step) {
		fc_int.moveDown(step);
		figurePanelp.setFigures(fc_int.getFigures());
		figurePanelp.repaint();
		
	}

	@Override
	public void moveLeftRq(int step) {
		fc_int.moveLeft(step);
		figurePanelp.setFigures(fc_int.getFigures());
		figurePanelp.repaint();
		
	}

	@Override
	public void moveRightRq(int step) {
		fc_int.moveRight(step);
		figurePanelp.setFigures(fc_int.getFigures());
		figurePanelp.repaint();
		
	}
}
