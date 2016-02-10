package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import application.ActionModule;
import application.ActionUIListener;
import application.GoodsModule;
import application.ShopApplication;
import logic.Goods;

public class GoodsUI extends JPanel {
	private int height = 20;
	private JComboBox<Goods> cbGoodsList = new JComboBox<>();
	private JLabel lblGoodsList = new JLabel("Goods List");
	private JLabel lblGName = new JLabel("Product name");
	private JLabel lblGUnit = new JLabel("Base measurement unit");
	private JTextField jtfName = new JTextField();
	private JTextField jtfUnit = new JTextField();
	private JButton btAdd = new JButton("Add");
	private JButton btDelete = new JButton("Delete");
	private JButton btUpdate = new JButton("Update");
	private JButton btClear = new JButton("Clear");
	private JButton btBack = new JButton("Back");
	private Goods product;
	private ActionUIListener actionUIListener;
	private List<Goods> goods = new ArrayList<>();
	private int index;
	private String tempString;
	private boolean formDataChanged = false;
	private boolean possiblyNewRecord = false;

	public GoodsUI(GoodsModule goodsModule) {
		setBorder(new TitledBorder("Goods management"));
		setLayout(new GridLayout(6, 2));
		add(btBack);
		add(Box.createVerticalStrut(height));
		add(lblGoodsList);
		add(cbGoodsList);
		add(lblGName);
		add(jtfName);
		add(lblGUnit);
		add(jtfUnit);
		btAdd.setEnabled(goodsModule.isInsertOK());
		btDelete.setEnabled(goodsModule.isDeleteOK());
		btUpdate.setEnabled(goodsModule.isUpdateOK());
		add(btAdd);
		add(btDelete);
		add(btUpdate);
		add(btClear);
		jtfUnit.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (!jtfUnit.getText().equals(tempString)) {
					formDataChanged = true;
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				tempString = jtfUnit.getText();

			}
		});
		jtfName.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (!jtfName.getText().equals(tempString)) {
					formDataChanged = true;
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				tempString = jtfName.getText();

			}
		});
		btAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!possiblyNewRecord){
					showMessage("Not new record, use UPDATE instead!");
				}
				else if (!formDataChanged) {
					showMessage("Nothing to add!");
				} else if (jtfName.getText().equals("")) {
					showMessage("Empty product name!");
				} else if (jtfUnit.getText().equals("")) {
					showMessage("Empty measurement unit!");

				} else if (!ShopApplication.isInteger(jtfUnit.getText())) {
					showMessage("Invalid measurement unit!");

				} else {
					actionUIListener.doAction(GoodsModule.CMD_ADD_ITEM,
							new Goods(jtfName.getText(), Integer.parseInt(jtfUnit.getText())));
					updateGoodsList();
				}
			}
		});
		btBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (actionUIListener != null) {
					actionUIListener.doAction(GoodsModule.CMD_EXIT, null);
				}

			}
		});
		cbGoodsList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showSelectedItem();

			}
		});
		btClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clearFormData();

			}

		});
		btDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actionUIListener.doAction(GoodsModule.CMD_DELETE_ITEM, product);
				possiblyNewRecord = false;
				formDataChanged = false;
				updateGoodsList();
			}
		});
		btUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(possiblyNewRecord){
					showMessage("New record, use ADD instead!");
				}
				else if (!formDataChanged) {
					showMessage("Nothing to add!");
				} else if (jtfName.getText().equals("")) {
					showMessage("Empty product name!");
				} else if (jtfUnit.getText().equals("")) {
					showMessage("Empty measurement unit!");

				} else if (!ShopApplication.isInteger(jtfUnit.getText())) {
					showMessage("Invalid measurement unit!");

				} else {
					product.setName(jtfName.getText());
					product.setUnit(Integer.parseInt(jtfUnit.getText()));
					actionUIListener.doAction(GoodsModule.CMD_UPDATE_ITEM, product);
					
				}

			}
		});
		setActionUIListener(goodsModule);
		updateGoodsList();

	}

	private void clearFormData() {
		jtfName.setText("");
		jtfUnit.setText("");
		possiblyNewRecord = true;
		tempString = "";

	}

	private void updateGoodsList() {
		goods = ((GoodsModule) actionUIListener).getUpdatedGoodsList();
		cbGoodsList.removeAllItems();
		for (Goods item : goods) {
			cbGoodsList.addItem(item);
			possiblyNewRecord = false;
			formDataChanged = false;
		}
	}

	private void showSelectedItem() {
		product = (Goods) cbGoodsList.getSelectedItem();
		if (product != null) {
			jtfName.setText(product.getName());
			jtfUnit.setText(Integer.toString(product.getUnit()));

		}

	}

	public void setActionUIListener(ActionUIListener actionUIListener) {
		this.actionUIListener = actionUIListener;
	}

	public void showMessage(String text) {
		JOptionPane.showMessageDialog(this, text);

	}

}
