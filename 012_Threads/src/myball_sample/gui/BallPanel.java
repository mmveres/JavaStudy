package myball_sample.gui;

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
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import myball_sample.entity.Ball;

public class BallPanel extends JPanel {

	MainWindow mainWindow;

	public BallPanel(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // erase background
		Graphics2D g2 = (Graphics2D) g;
//		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		for (Ball b : mainWindow.getBalls()) {
			g2.setColor(b.getColor());
			g2.fill(b.getShape());
		}
		
	}

}