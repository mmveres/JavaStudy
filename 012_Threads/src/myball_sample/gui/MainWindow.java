package myball_sample.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.ListModel;

import myball_sample.entity.Ball;

import javax.swing.JButton;

public class MainWindow extends JFrame {

	BallPanel fieldPanel;
	JPanel controlsPanel = new JPanel();
	JButton btnNewBall = new JButton("Add ball");
	JButton btnStart = new JButton("Start");
	JButton btnStop = new JButton("Stop");
	JButton btnClear = new JButton("Clear");
	private List<Ball> balls = new ArrayList<>();
	DefaultListModel<Ball> dlmBalls = new DefaultListModel<>();
	JList<Ball> ballsList = new JList<>();
	private boolean showOn;

	/**
	 * Add a ball to the component.
	 * 
	 * @param b
	 *            the ball to add
	 */

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 300);
		setMinimumSize(new Dimension(800, 300));
//		setResizable(false);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		fieldPanel = new BallPanel(this);
		add(fieldPanel);
		add(controlsPanel);
		controlsPanel.setLayout(new BoxLayout(controlsPanel, BoxLayout.Y_AXIS));
		// controlsPanel.add(ballsList);
		controlsPanel.add(btnStart);
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showOn = true;
//				System.out.println("click");
//				fieldPanel.paint(fieldPanel.getGraphics());
				Thread t=new Thread(new Runnable() {
					public void run() {
						int counter=0;
						while(showOn){
//							if (counter++%10==0) {
//								System.out.println("frame " + counter);
//
//							}
							fieldPanel.paint(fieldPanel.getGraphics());
							try {
								Thread.sleep(20);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				});
				t.setPriority(Thread.MAX_PRIORITY);
				t.start();
				btnStop.setEnabled(true);
				btnStart.setEnabled(false);

			}
		});
		controlsPanel.add(btnStop);
		btnStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showOn = false;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnStop.setEnabled(false);
				btnStart.setEnabled(true);

			}
		});
		controlsPanel.add(btnNewBall);
		btnNewBall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addRandomBall();
				updateList();

			}

		});
		controlsPanel.add(btnClear);
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAllBalls();

			}
		});
	}

	public void init() {
		setVisible(true);
	}

	private void addRandomBall() {
		Ball b = new Ball(fieldPanel);

		new Thread(b).start();
		balls.add(b);

	}

	private void removeAllBalls() {
for (Ball ball : balls) {
	ball.setAlive(false);
	
}
balls=new ArrayList<>();


		// ballsList.removeAll();
	}

	private void updateList() {
		ballsList.removeAll();
		for (Ball ball : balls) {
			dlmBalls.addElement(ball);
		}

	}

	public List<Ball> getBalls() {
		return balls;
	}

}
