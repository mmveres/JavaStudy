package figures;

import java.awt.Color;

import exceptions.NullLengthLineException;

public class ColorLine extends Line implements Colorable{
	private Color color;

	public ColorLine(Point start, Point end, Color color) throws NullLengthLineException {
		super(start, end);
		this.color=color;
//		super(start.getX(), start.getY(), end.getX(), end.getY());
	}

	public ColorLine(int x1, int y1, int x2, int y2, Color color) throws NullLengthLineException {
		super(x1,y1,x2,y2);
		this.color=color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	@Override
	public String toString() {

		return super.toString() + " color=" + color;
	}

//	@Override
//	public int compareTo(Color o) {
//		int intColor=(1+this.color.getRed())*(1+this.color.getGreen()*(1+this.color.getBlue()));
//		int extColor=(1+o.getRed())*(1+o.getGreen()*(1+o.getBlue()));
//		if(intColor==extColor) return 0;
//		if(intColor<extColor) return -1;
//		if(intColor>extColor) return 1;
//		
//	}

}
