package myball_sample.app;

import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.SwingUtilities;

import myball_sample.gui.MainWindow;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainWindow window = new MainWindow();
				window.init();

			}
		});
	}

}
