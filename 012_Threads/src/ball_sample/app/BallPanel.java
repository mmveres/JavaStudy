package ball_sample.app;

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
 * The component that draws the balls.
 * 
 * @version 1.33 2007-05-17
 * @author Cay Horstmann
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import ball_sample.entity.Ball;

public class BallPanel extends JPanel {
	private ArrayList<Ball> balls = new ArrayList<>();
	
  /**
   * Add a ball to the component.
   * 
   * @param b
   *          the ball to add
   */
  public void add(Ball b) {
    balls.add(b);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g); // erase background
    Graphics2D g2 = (Graphics2D) g;
    for (Ball b : balls) {
      g2.fill(b.getShape());
    }
  }

  
}