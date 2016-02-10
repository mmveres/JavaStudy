package figures.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle.Control;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicArrowButton;

public class ControlPanel extends JPanel {
	private JButton btnGenerate = new JButton("Generate");
	private JButton btnChangeClr = new JButton("Change color");
	private JTextField tfMoveStep = new JTextField("5");

	private BasicArrowButton btnMoveUp = new BasicArrowButton(BasicArrowButton.NORTH);
	private BasicArrowButton btnMoveDown = new BasicArrowButton(BasicArrowButton.SOUTH);
	private BasicArrowButton btnMoveLeft = new BasicArrowButton(BasicArrowButton.WEST);
	private BasicArrowButton btnMoveRight = new BasicArrowButton(BasicArrowButton.EAST);
	private JButton btnColor = new JButton("    ");
	private JSlider sliderR = new JSlider(JSlider.HORIZONTAL, 15, 250, 125);
	private JSlider sliderG = new JSlider(JSlider.HORIZONTAL, 15, 250, 125);
	private JSlider sliderB = new JSlider(JSlider.HORIZONTAL, 15, 250, 125);
	private int cR;;
	private int cG;
	private int cB;
	private Color myColor;
	private ControlPanelListener myListener;

	public void setControlPanelListener(ControlPanelListener myListener) {
		this.myListener = myListener;
	}

	public ControlPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new TitledBorder("Controls"));
		add(Box.createVerticalStrut(10));
		add(btnGenerate);
		add(Box.createVerticalStrut(10));
		sliderR.setBackground(new Color(250, 150, 150));
		sliderG.setBackground(new Color(0, 210, 0));
		sliderB.setBackground(new Color(210, 250, 250));
		add(sliderR);
		add(sliderG);
		add(sliderB);
		
		cR = cB = cG = 125;
		updateRefereceColor();
		btnColor.setEnabled(false);
		add(Box.createVerticalStrut(10));
		add(btnColor);
		add(Box.createVerticalStrut(10));
		add(btnChangeClr);
		add(Box.createVerticalGlue());
		add(Box.createVerticalStrut(10));
		add(tfMoveStep);
		add(Box.createVerticalStrut(10));
		add(btnMoveUp);
		add(btnMoveDown);
		add(btnMoveLeft);
		add(btnMoveRight);
		add(Box.createVerticalGlue());
		btnGenerate.setAlignmentX(CENTER_ALIGNMENT);
		btnChangeClr.setAlignmentX(CENTER_ALIGNMENT);
		tfMoveStep.setAlignmentX(RIGHT_ALIGNMENT);
		btnColor.setAlignmentX(CENTER_ALIGNMENT);
		sliderR.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				cR = ((JSlider) e.getSource()).getValue();
				updateRefereceColor();
				btnColor.repaint();

			}
		});
		sliderG.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				cG = ((JSlider) e.getSource()).getValue();
				updateRefereceColor();
				btnColor.repaint();

			}
		});
		sliderB.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				cB = ((JSlider) e.getSource()).getValue();
				updateRefereceColor();
				btnColor.repaint();

			}
		});
		btnGenerate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myListener.generateNewSet();

			}
		});
		btnChangeClr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myListener.changeColor(myColor);

			}
		});
		btnMoveUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myListener.moveUpRq(Integer.parseInt(tfMoveStep.getText()));

			}
		});
		btnMoveDown.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myListener.moveDownRq(Integer.parseInt(tfMoveStep.getText()));

			}
		});
		btnMoveLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myListener.moveLeftRq(Integer.parseInt(tfMoveStep.getText()));

			}
		});
		btnMoveRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myListener.moveRightRq(Integer.parseInt(tfMoveStep.getText()));

			}
		});
	}

	private void updateRefereceColor() {

		myColor = new Color(cR, cG, cB);
		btnColor.setBackground(myColor);
	}

}
