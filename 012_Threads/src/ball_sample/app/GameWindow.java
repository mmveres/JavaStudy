package ball_sample.app;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ball_sample.entity.Ball;

/**
 * The frame with ball component and buttons.
 */
public class GameWindow extends JFrame {
  /**
   * Constructs the frame with the component for showing the bouncing ball and
   * Start and Close buttons
   */
	
	  private BallPanel panel;

	  public static final int DEFAULT_WIDTH = 450;

	  public static final int DEFAULT_HEIGHT = 350;

	  public static final int STEPS = 1000;

	  public static final int DELAY = 3;
	
  public GameWindow() {
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    setTitle("Bounce");

    panel = new BallPanel();
    add(panel, BorderLayout.CENTER);
    JPanel buttonPanel = new JPanel();
    addButton(buttonPanel, "Start", new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        addBall();
      }
    });

    addButton(buttonPanel, "Close", new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        System.exit(0);
      }
    });
    add(buttonPanel, BorderLayout.SOUTH);
  }

  /**
   * Adds a button to a container.
   * 
   * @param c
   *          the container
   * @param title
   *          the button title
   * @param listener
   *          the action listener for the button
   */
  public void addButton(Container c, String title, ActionListener listener) {
    JButton button = new JButton(title);
    c.add(button);
    button.addActionListener(listener);
  }

  /**
   * Adds a bouncing ball to the panel and makes it bounce 1,000 times.
   */
  public void addBall() {
    try {
      Ball ball = new Ball();
      panel.add(ball);

      for (int i = 1; i <= STEPS; i++) {
        ball.move(panel.getBounds());
        panel.paint(panel.getGraphics());
        Thread.sleep(DELAY);
      }
    } catch (InterruptedException e) {
    }
  }


}
