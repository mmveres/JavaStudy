package figures.gui;

import java.awt.Color;

public interface ControlPanelListener {
	void generateNewSet();
	void changeColor(Color color);
	void moveUpRq(int step);
	void moveDownRq(int step);
	void moveLeftRq(int step);
	void moveRightRq(int step);
}
