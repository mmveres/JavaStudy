package figures.tools;

import java.awt.Color;

import exceptions.NotATriangleException;
import exceptions.NullLengthLineException;
import figures.ColorLine;
import figures.ColorPoint;
import figures.ColorTriangle;
import figures.Colorable;
import figures.Figure;
import figures.Line;
import figures.Point;
import figures.Triangle;



public class Generator {
	
	public static final int MIN_VALUE=-20;
	public static final int MAX_VALUE=20;
	
	public static int getRandInt(){
		return MIN_VALUE + (int)(Math.random()*(MAX_VALUE-MIN_VALUE));
	}
	
	public static Color randColor(){
		int R = 15+(int)(Math.random()*230);
		int G = 15+(int)(Math.random()*230);
		int B= 15+(int)(Math.random()*230);
		return new Color(R, G, B);
	}
	
	public static Colorable randColorable() {
		switch ((int) (Math.random() * 4)) {
		case 0:return new ColorPoint(getRandInt(), getRandInt(), randColor());


		case 1:	try {
				return new ColorLine(getRandInt(), getRandInt(),getRandInt(),getRandInt(),randColor());
			} catch (NullLengthLineException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		default:return null;}
		
	}

	public static Figure randFigure() {
		//fabric method
		switch ((int) (Math.random() * 6)) {
		case 0:return new Point(getRandInt(), getRandInt());

		case 1:	return new ColorPoint(getRandInt(), getRandInt(), randColor());

		case 2:	try {
				return new Line(getRandInt(), getRandInt(),getRandInt(),getRandInt());
			} catch (NullLengthLineException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		case 3:	try {
				return new ColorLine(getRandInt(), getRandInt(),getRandInt(),getRandInt(),randColor());
			} catch (NullLengthLineException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		case 4:	try {
				return new Triangle(getRandInt(), getRandInt(), getRandInt(), getRandInt(), getRandInt(), getRandInt());
			} catch (NotATriangleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		case 5:	try {
				return new ColorTriangle(getRandInt(), getRandInt(), getRandInt(), getRandInt(), getRandInt(), getRandInt(), randColor());
			} catch (NotATriangleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		default:return null;
		}
	}
}
