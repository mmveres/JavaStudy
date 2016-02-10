package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import application.ActionModule;
import application.ActionUIListener;
import application.ShopApplication;

public class ActionUI extends JPanel {
	private String textSales = "Manage Sales";
	private String textSupplies = "Manage Supplies";
	private String textViewMovement = "View goods movement";
	private String textGoods= "Manage Goods";
	private int height = 20;
	private JButton btSales = new JButton(textSales);
	private JButton btSupplies = new JButton(textSupplies);
	private JButton btView = new JButton(textViewMovement);
	private JButton btGoods = new JButton(textGoods);
	private ActionUIListener actionUIListener;

	public ActionUI() {
		setBorder(new TitledBorder("Select action"));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(Box.createVerticalStrut(height));
		add(btGoods);
		add(Box.createVerticalStrut(height));
		add(btSupplies);
		add(Box.createVerticalStrut(height));
		add(btSales);
		add(Box.createVerticalStrut(height));
		add(btView);
		add(Box.createVerticalStrut(height));
		btSales.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (actionUIListener != null) {
					actionUIListener.doAction(ActionModule.CMD_CALL_SALES,null);
				}
			}

		});
		btSupplies.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (actionUIListener != null) {
					actionUIListener.doAction(ActionModule.CMD_CALL_SUPPLIES,null);
				}
			}
		});
		btView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (actionUIListener != null) {
					actionUIListener.doAction(ActionModule.CMD_CALL_VIEW,null);
				}
			}
		});
		btGoods.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (actionUIListener != null) {
					actionUIListener.doAction(ActionModule.CMD_CALL_GOODS,null);
				}
			}
		
		});

	}

	public void setActionUIListener(ActionUIListener actionUIListener) {
		this.actionUIListener = actionUIListener;
	}

}
