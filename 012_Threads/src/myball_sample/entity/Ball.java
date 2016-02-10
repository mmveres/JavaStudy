package myball_sample.entity;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

/*
 * This program is a part of the companion code for Core Java 8th ed.
 * (http://horstmann.com/corejava)
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * A ball that moves and bounces off the edges of a rectangle
 * 
 * @version 1.33 2007-05-17
 * @author Cay Horstmann
 */
public class Ball implements Runnable {

	private static int counter;

	private int sizeX = 50;

	private int sizeY = 50;

	private double x = 0;

	private double y = 0;

	private double dx = 2;

	private double dy = 2;

	private JPanel panel;

	private Color color;

	private final int id = counter++;

	private boolean alive = true;

	public Ball(JPanel panel) {
		this.panel = panel;
		color = new Color(getRandomComp(), getRandomComp(), getRandomComp());
		x=(int)(Math.random()*panel.getBounds().getWidth());
		x=(int)(Math.random()*panel.getBounds().getHeight());
		sizeX=10+10*(int)(Math.random()*5);
		sizeY=sizeX;
		dx=1*(int)(Math.random()*10);
		dy=1*(int)(Math.random()*10);
		

	}

	public Color getColor() {
		return color;
	}

	private int getRandomComp() {

		return 51 + 51 * (int) (Math.random() * 5);
	}

	private Ellipse2D.Double ellipse = new Ellipse2D.Double(x, y, sizeX, sizeY);

	/**
	 * Moves the ball to the next position, reversing direction if it hits one
	 * of the edges
	 */

	public void move() {

		x += dx;
		y += dy;
		if (x < panel.getBounds().getMinX()) {
			x = panel.getBounds().getMinX();
			dx = -dx;
		}
		if (x + sizeX >= panel.getBounds().getMaxX()) {
			x = panel.getBounds().getMaxX() - sizeX;
			dx = -dx;
		}
		if (y < panel.getBounds().getMinY()) {
			y = panel.getBounds().getMinY();
			dy = -dy;
		}
		if (y + sizeY >= panel.getBounds().getMaxY()) {
			y = panel.getBounds().getMaxY() - sizeY;
			dy = -dy;
		}
	}

	public Ball(double x, double y, double dx, double dy, Double ellipse) {
		super();
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.ellipse = ellipse;
	}

	/**
	 * Gets the shape of the ball at its current position.
	 */
	public Ellipse2D getShape() {
		ellipse.setFrame(x, y, sizeX, sizeY);
		return ellipse;
	}

	@Override
	public void run() {
		int counter = 0;
		while (alive) {
			move();
//			if (counter++ == 10) {
//				System.out.println(toString() + " moved");
//				counter = 0;
//			}
			try {
				Thread.sleep(30L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	@Override
	public String toString() {
		return "Ball [id=" + id + ", x=" + x + ", y=" + y + "]";
	}



}