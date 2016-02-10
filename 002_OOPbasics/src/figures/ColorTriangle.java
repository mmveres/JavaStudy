package figures;

import java.awt.Color;

import exceptions.NotATriangleException;

public class ColorTriangle extends Triangle implements Colorable{
	private Color color;

	public ColorTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Color color) throws NotATriangleException {
		super(x1, y1, x2, y2, x3, y3);
		this.color = color;
	}

	public ColorTriangle(Point point1, Point point2, Point point3, Color color) throws NotATriangleException {
		super(point1, point2, point3);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
 
	@Override
	public String toString() {
		
		return super.toString() + " color= " + color;
	}

//	@Override
//	public int compareTo(Color o) {
//		int intColor=(1+this.color.getRed())*(1+this.color.getGreen()*(1+this.color.getBlue()));
//		int extColor=(1+o.getRed())*(1+o.getGreen()*(1+o.getBlue()));
//		if(intColor==extColor) return 0;
//		if(intColor<extColor) return -1;
//		if(intColor>extColor) return 1;
//	}
}
