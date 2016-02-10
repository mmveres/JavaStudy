package figures.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

import figures.ColorLine;
import figures.ColorPoint;
import figures.ColorTriangle;
import figures.Colorable;
import figures.Figure;
import figures.Line;
import figures.Point;
import figures.Triangle;

public class FigurePanel extends JPanel{



private static final long serialVersionUID = 3003159528774179653L;
private Graphics2D graphics2d;
private Figure[] figures;

private final float adjustment = 0.9f;
private int width;
private int height;
private int minX;
private int minY;
private int maxX;
private int maxY;
private int zeroX;
private int zeroY;
private float stepX;
private float stepY;
private Color color;

public FigurePanel(Figure[] f) {
	this.figures = f;

}

	public void setFigures(Figure[] figures) {
		this.figures = figures;
	}
	


	@Override
public void paint(Graphics g) {

	super.paint(g);
	if (figures.length > 0) {
		graphics2d = (Graphics2D) g;
		height = getHeight();
		width = getWidth();
		defineBoundCoordinates(figures);

//		System.out.println(minX + " " + minY + " " + maxX + " " + maxY);
		defineStep();
		defineZero();
		drawAxis();

		for (int i = 0; i < figures.length; i++) {
//			System.out.println("========================" + i + "===========================");
			if (figures[i].getClass() == Point.class) {

				drawColorPoint(Color.BLACK, ((Point) figures[i]));
			}
			if (figures[i].getClass() == ColorPoint.class) {

				drawColorPoint(((ColorPoint) figures[i]).getColor(), ((ColorPoint) figures[i]));
			}

			if (figures[i].getClass() == Line.class) {

				drawColorLine(Color.BLACK, ((Line) figures[i]).getStart(), ((Line) figures[i]).getEnd());
			}
			if (figures[i].getClass() == ColorLine.class) {

				drawColorLine(((ColorLine) figures[i]).getColor(), ((ColorLine) figures[i]).getStart(),
						((ColorLine) figures[i]).getEnd());
			}
			if (figures[i].getClass() == Triangle.class) {

				drawColorTriangle(Color.BLACK, ((Triangle) figures[i]).getPoint1(), ((Triangle) figures[i]).getPoint2(),
						((Triangle) figures[i]).getPoint3());

			}
			if (figures[i].getClass() == ColorTriangle.class) {

				drawColorTriangle(((ColorTriangle) figures[i]).getColor(), ((Triangle) figures[i]).getPoint1(),
						((Triangle) figures[i]).getPoint2(), ((Triangle) figures[i]).getPoint3());

			}
		}
	}

}

private void defineStep() {
	stepX = ((float) width) * adjustment / (maxX - minX);
	stepY = ((float) height) * adjustment / (maxY - minY);
}

private void defineZero() {
	if (minX >= 0) {
		zeroX = 0;
	} else {
		zeroX = -minX;
	}
	if (minY >= 0) {
		zeroY = 0;
	} else {
		zeroY = -minY;
	}
	zeroX = (int) (zeroX * stepX);
	zeroY = (int) (height - zeroY * stepY);

}

private int transformY(int y) {

	return zeroY - (int) (y * stepY);
}

private int transformX(int x) {

	return zeroX + (int) (x * stepX);
}

private void defineBoundCoordinates(Figure[] figureArray) {
	minX = 0;
	minY = 0;
	maxX = 0;
	maxY = 0;
	for (int i = 0; i < figureArray.length; i++) {
		if (figures[i] instanceof Point) {
			setMinMaxPointCoord(((Point) figures[i]));

		}
		if (figures[i] instanceof Line) {
			setMinMaxPointCoord(((Line) figures[i]).getStart());
			setMinMaxPointCoord(((Line) figures[i]).getEnd());

		}
		if (figures[i] instanceof Triangle) {
			setMinMaxPointCoord(((Triangle) figures[i]).getPoint1());
			setMinMaxPointCoord(((Triangle) figures[i]).getPoint2());
			setMinMaxPointCoord(((Triangle) figures[i]).getPoint3());
		}
	}
}

private void setMinMaxPointCoord(Point p) {
	if (p.getX() < minX) {
		minX = p.getX();
	}
	if (p.getY() < minY) {
		minY = p.getY();
	}
	if (p.getX() > maxX) {
		maxX = p.getX();
	}
	if (p.getY() > maxY) {
		maxY = p.getY();
	}
}

private void drawColorLine(Color color, Point start, Point end) {
	graphics2d.setPaint(color);
	int x1 = transformX(start.getX());
	int y1 = transformY(start.getY());
	Point2D.Float start2d = new Point2D.Float(x1, y1);
	int x2 = transformX(end.getX());
	int y2 = transformY(end.getY());
	Point2D.Float end2d = new Point2D.Float(x2, y2);
//	System.out.println("Line");
//	System.out.println(x1 + " " + y1);
//	System.out.println(x2 + " " + y2);
	graphics2d.draw(new Line2D.Float(start2d, end2d));
}

private void drawColorPoint(Color color, Point point) {
	graphics2d.setPaint(color);
	int x = transformX(point.getX());
	int y = transformY(point.getY());
//	System.out.println("Point");
//	System.out.println(x + " " + y);
	Point2D.Float p2d = new Point2D.Float(x, y);
	graphics2d.draw(new Line2D.Float(p2d, p2d));
}

private void drawAxis() {
	graphics2d.setPaint(Color.GRAY);
	graphics2d.draw(new Line2D.Float(0, zeroY, width, zeroY));
	graphics2d.draw(new Line2D.Float(zeroX, 0, zeroX, height));
}

private void drawColorTriangle(Color color, Point point1, Point point2, Point point3) {
	graphics2d.setPaint(color);
	int x1 = transformX(point1.getX());
	int y1 = transformY(point1.getY());
	Point2D.Float p1 = new Point2D.Float(x1, y1);
	int x2 = transformX(point2.getX());
	int y2 = transformY(point2.getY());
	Point2D.Float p2 = new Point2D.Float(x2, y2);
	int x3 = transformX(point3.getX());
	int y3 = transformY(point3.getY());
	Point2D.Float p3 = new Point2D.Float(x3, y3);
//	System.out.println("Triangle");
//	System.out.println(x1 + " " + y1);
//	System.out.println(x2 + " " + y2);
//	System.out.println(x3 + " " + y3);
	graphics2d.draw(new Line2D.Float(p1, p2));
	graphics2d.draw(new Line2D.Float(p2, p3));
	graphics2d.draw(new Line2D.Float(p1, p3));

}



}