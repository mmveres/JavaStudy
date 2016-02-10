package figures;

import java.awt.Color;

public class ColorSomething implements Colorable {
	private Color color;

	public ColorSomething(Color color) {
		super();
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
		return "ColorSomething [color=" + color + "]";
	}

//	@Override
//	public int compareTo(Color o) {
//		int intColor = (1 + this.color.getRed()) * (1 + this.color.getGreen() * (1 + this.color.getBlue()));
//		int extColor = (1 + o.getRed()) * (1 + o.getGreen() * (1 + o.getBlue()));
//		if (intColor == extColor)
//			return 0;
//		if (intColor < extColor)
//			return -1;
//		if (intColor > extColor)
//			return 1;
//	}

}
