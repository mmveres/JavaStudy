package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import application.ActionModule;
import application.ActionUIListener;
import application.SuppliesModule;
import application.ShopApplication;
import application.SuppliesModule;
import logic.Goods;
import logic.Supplies;

public class SuppliesUI extends JPanel {
	private int height = 20;
	private JComboBox<Supplies> cbSuppliesList = new JComboBox<>();
	private JLabel lblSuppliesList = new JLabel("Supplies List");
	private JLabel lblDate = new JLabel("Supply date (DDMMYYYY)");
	private JLabel lblSupplier = new JLabel("Supplier");
	private JTextField jtfDate = new JTextField(8);
	private JTextField jtfSupplier = new JTextField(15);
	private JButton btAdd = new JButton("Add");
	private JButton btDelete = new JButton("Delete");
	private JButton btUpdate = new JButton("Update");
	private JButton btClear = new JButton("Clear");
	private JButton btBack = new JButton("Back");
	private DefaultListModel<Goods> supGoodsItems = new DefaultListModel();
	private JList<Goods> supGoodsList = new JList(supGoodsItems);
	private DefaultListModel<Goods> allGoodsItems = new DefaultListModel();
	private JList<Goods> allGoodsList = new JList(allGoodsItems);

	private Supplies supply;
	private ActionUIListener actionUIListener;
	private List<Supplies> supplies = new ArrayList<>();
	private String tempString;
	private boolean formDataChanged = false;
	private boolean possiblyNewRecord = false;
	private SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");

	public SuppliesUI(SuppliesModule suppliesModule) {
		setBorder(new TitledBorder("Supplies management"));
		setLayout(new GridLayout(7, 2));
		add(btBack);
		add(Box.createVerticalStrut(height));
		add(lblSuppliesList);
		add(cbSuppliesList);
		add(lblDate);
		add(jtfDate);
		add(lblSupplier);
		add(jtfSupplier);
		btAdd.setEnabled(suppliesModule.isInsertOK());
		btDelete.setEnabled(suppliesModule.isDeleteOK());
		btUpdate.setEnabled(suppliesModule.isUpdateOK());
		add(allGoodsList);
		add(supGoodsList);
		add(btAdd);
		add(btDelete);
		add(btUpdate);
		add(btClear);
		jtfSupplier.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (!jtfSupplier.getText().equals(tempString)) {
					formDataChanged = true;
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				tempString = jtfSupplier.getText();

			}
		});
		jtfDate.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (!jtfDate.getText().equals(tempString)) {
					formDataChanged = true;
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				tempString = jtfDate.getText();

			}
		});
		btAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!possiblyNewRecord) {
					showMessage("Not new record, use UPDATE instead!");
				} else if (!formDataChanged) {
					showMessage("Nothing to add!");
				} else if (jtfDate.getText().equals("")) {
					showMessage("Empty date!");
				} else if (jtfSupplier.getText().equals("")) {
					showMessage("Empty supplier name!");

				} else {

					try {
						SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
						Date date = sdf.parse(jtfDate.getText());
						actionUIListener.doAction(SuppliesModule.CMD_ADD_ITEM,
								new Supplies(date, jtfSupplier.getText()));
						updateSuppliesList();
					} catch (ParseException e1) {
						showMessage("Invalid date!");
						e1.printStackTrace();
					}

				}
			}
		});
		btBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (actionUIListener != null) {
					actionUIListener.doAction(SuppliesModule.CMD_EXIT, null);
				}

			}
		});
		cbSuppliesList.addActionListener(new ActionListener() {

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
				actionUIListener.doAction(SuppliesModule.CMD_DELETE_ITEM, supply);
				possiblyNewRecord = false;
				formDataChanged = false;
				updateSuppliesList();
			}
		});
		btUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (possiblyNewRecord) {
					showMessage("New record, use ADD instead!");
				} else if (!formDataChanged) {
					showMessage("Nothing to add!");
				} else if (jtfDate.getText().equals("")) {
					showMessage("Empty date!");
				} else if (jtfSupplier.getText().equals("")) {
					showMessage("Empty supplier name!");

				} else {
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
						Date date = sdf.parse(jtfDate.getText());
						supply.setDate(date);
						supply.setSupplier(jtfSupplier.getText());
						actionUIListener.doAction(SuppliesModule.CMD_UPDATE_ITEM, supply);
						updateSuppliesList();
					} catch (ParseException e1) {
						showMessage("Invalid date!");
						e1.printStackTrace();
					}

				}

			}
		});
		setActionUIListener(suppliesModule);
		updateSuppliesList();


	}

	private void updateGoodsList() {
		System.out.println("clear called!");
		supGoodsItems.removeAllElements();
		//((DefaultListModel<Goods>)supGoodsList.getModel()).removeAllElements();
		actionUIListener.doAction(SuppliesModule.CMD_GET_FULL_ITEM_BY_ID, supply.getSupply_id());
		supply=((SuppliesModule)actionUIListener).getSupply();
		if (supply.getGoods() != null) {
			for (Goods g : supply.getGoods()) {
				supGoodsItems.addElement(g);
			}
		}

	}

	private void clearFormData() {
		jtfDate.setText("");
		jtfSupplier.setText("");
		possiblyNewRecord = true;
		tempString = "";

	}

	private void updateSuppliesList() {
		supplies = ((SuppliesModule) actionUIListener).getUpdatedSuppliesList();
		cbSuppliesList.removeAllItems();
		for (Supplies item : supplies) {
			cbSuppliesList.addItem(item);
			possiblyNewRecord = false;
			formDataChanged = false;
		}
	updateGoodsList();
	}

	private void showSelectedItem() {
		supply = (Supplies) cbSuppliesList.getSelectedItem();
		if (supply != null) {
			jtfDate.setText(sdf.format(supply.getDate()));
			jtfSupplier.setText(supply.getSupplier());

		}
		updateGoodsList();

	}

	public void setActionUIListener(ActionUIListener actionUIListener) {
		this.actionUIListener = actionUIListener;
	}

	public void showMessage(String text) {
		JOptionPane.showMessageDialog(this, text);

	}

}
