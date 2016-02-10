package gui;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class UIContainer extends JFrame {
	private String login;
	private String password;

	public UIContainer() {
		setTitle(getClass().getSimpleName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void clearUI(final Component component) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				setVisible(false);
				remove(component);
				
			}
		});

		
	}

	public void initUI(final Component component) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				add(component);
				pack();
				setVisible(true);
				
			}
		});

		
	}


}
