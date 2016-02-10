package ball_sample_2;

// GUI BALL
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BallDemo extends JFrame {
	JPanel panel = new JPanel();
	Graphics g;
	JButton btn = new JButton("create ball");
	int i;

	public BallDemo() {
		setBounds(100, 200, 270, 350);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		btn.setBounds(50, 10, 160, 20);
		contentPane.add(btn);
		panel.setBounds(30, 40, 200, 200);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				new BallThread(panel).start();
				i++;
				repaint();
			}
		});
	}

	public static void main(String[] args) {
		BallDemo frame = new BallDemo();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("count ball: " + i, 65, 300);
	}
}

class BallThread extends Thread {
	JPanel panel;
	private int posX, posY;
	private final int BALL_SIZE = 10;
	private double alpha;
	private int SPEED = 4;

	BallThread(JPanel p) {
		this.panel = p;
		posX = (int) ((panel.getWidth() - BALL_SIZE) * Math.random());
		posY = (int) ((panel.getHeight() - BALL_SIZE) * Math.random());
		alpha = Math.random() * 10;
	}

	public void run() {
		while (true) {
			posX += (int) (SPEED * Math.cos(alpha));
			posY += (int) (SPEED * Math.sin(alpha));
			if (posX >= panel.getWidth() - BALL_SIZE)
				alpha = alpha + Math.PI - 2 * alpha;
			else if (posX <= 0)
				alpha = Math.PI - alpha;
			if (posY >= panel.getHeight() - BALL_SIZE)
				alpha = -alpha;
			else if (posY <= 0)
				alpha = -alpha;
			paint(panel.getGraphics());
		}
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillArc(posX, posY, BALL_SIZE, BALL_SIZE, 0, 360);
		g.setColor(Color.WHITE);
		g.drawArc(posX + 1, posY + 1, BALL_SIZE, BALL_SIZE, 120, 30);
		try {
			sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		g.setColor(panel.getBackground());
		g.fillArc(posX, posY, BALL_SIZE, BALL_SIZE, 0, 360);
	}
}