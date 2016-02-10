package ball_sample.entity;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

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
public class Ball {
	
	  private static final int XSIZE = 15;

	  private static final int YSIZE = 15;

	  private double x = 0;

	  private double y = 0;

	  private double dx = 3;

	  private double dy = 5;
	  
	  private Ellipse2D.Double ellipse = new Ellipse2D.Double(x, y, XSIZE, YSIZE);
  /**
   * Moves the ball to the next position, reversing direction if it hits one of
   * the edges
   */
  public void move(Rectangle2D bounds) {
    x += dx;
    y += dy;
    if (x < bounds.getMinX()) {
      x = bounds.getMinX();
      dx = -dx;
    }
    if (x + XSIZE >= bounds.getMaxX()) {
      x = bounds.getMaxX() - XSIZE;
      dx = -dx;
    }
    if (y < bounds.getMinY()) {
      y = bounds.getMinY();
      dy = -dy;
    }
    if (y + YSIZE >= bounds.getMaxY()) {
      y = bounds.getMaxY() - YSIZE;
      dy = -dy;
    }
  }

  /**
   * Gets the shape of the ball at its current position.
   */
  public Ellipse2D getShape() {
	  ellipse.setFrame(x, y, XSIZE, YSIZE);
    return ellipse;
  }


}