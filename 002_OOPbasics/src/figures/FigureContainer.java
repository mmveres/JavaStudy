package figures;

import java.awt.Color;
import java.util.Arrays;

import figures.tools.Generator;

public class FigureContainer {
	private Figure[] figures;
	
	public FigureContainer() {
		generateFigureArray(5);
	}

	public Figure[] getFigures() {
		return figures;
	}

	public void setFigures(Figure[] figures) {
		this.figures = figures;
	}

	public void generateFigureArray(int qty) {
		figures = new Figure[qty];

		for (int i = figures.length - 1; i >= 0; i--) {
			figures[i] = Generator.randFigure();
		}
	}

	public void print() {

		for (int i = 0; i < figures.length; i++) {
			figures[i].print();

		}
	}
	

	public void moveUp(int step) {
		for (Figure figure : figures) {
			figure.moveUp(step);
		}

		
	}

	public void moveDown(int step) {
		for (Figure figure : figures) {
			figure.moveDown(step);
		}
		
	}


	public void moveLeft(int step) {
		for (Figure figure : figures) {
			figure.moveLeft(step);
		}
		
	}


	public void moveRight(int step) {
		for (Figure figure : figures) {
			figure.moveRight(step);
		}
		
		
	}
	
	public void setFiguresColor(Color color){
		for (Figure figure : figures) {
			if (figure instanceof Colorable){
				((Colorable)figure).setColor(color);
			}
		}
	}

}
