
import java.awt.Color;
import java.util.Arrays;

import exceptions.NotATriangleException;
import figures.ColorTriangle;
import figures.Colorable;
import figures.Figure;
import figures.FigureContainer;
import figures.Point;
import figures.gui.MyPainter;
import figures.gui.SwingConsole;
import figures.tools.Generator;

public class Main {

	public static void main(String[] args) {
		Colorable color=new Colorable() {
			private Color color;
			@Override
			public void setColor(Color color) {
				this.color=color;
				
			}
			
			@Override
			public Color getColor() {
				// TODO Auto-generated method stub
				return color;
			}
		};
		color.setColor(Color.RED);
		
		FigureContainer fc = new FigureContainer();
		MyPainter painter = new MyPainter(fc);
		SwingConsole.run(painter, 400, 400);
//		ColorTriangle ct = null;
//		try {
//			ct = new ColorTriangle(1, 1, 2, 2, 4, 6, Color.BLUE);
//		} catch (NotATriangleException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			ct.setPoint1(new Point(1, 8));
//		} catch (NotATriangleException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		};
//		System.out.println(ct.toString());
//		try {
//			ct.setPoint3(new Point(3, 3));
//		} catch (NotATriangleException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			ct.setPoint1(new Point(1, 1));
//		} catch (NotATriangleException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
