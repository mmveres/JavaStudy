package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Factory;
import gui.SuppliesUI;
import gui.UIContainer;
import logic.Supplies;
import logic.Tables;

public class SuppliesModule implements ActionUIListener {
	public static final int CMD_EXIT = 0;
	public static final int CMD_SEARCH_ITEM = 1;
	public static final int CMD_ADD_ITEM = 2;
	public static final int CMD_DELETE_ITEM = 3;
	public static final int CMD_UPDATE_ITEM = 4;
	public static final int CMD_GET_FULL_ITEM_BY_ID = 5;

	private UIContainer uiContainer;
	private static SuppliesModule suppliesModule;
	private Supplies supply;
	private SuppliesUI suppliesUI;
	private List<Supplies> supplies = new ArrayList<>();

	private boolean insertOK;
	private boolean updateOK;
	private boolean deleteOK;

	private ShopApplication shopApplication;
	private ModuleListener moduleListener;

	private SuppliesModule(ShopApplication shopApplication) {
		this.shopApplication = shopApplication;
		this.uiContainer = shopApplication.getUIContainer();
		moduleListener = ((ModuleListener) shopApplication);
		setPermissions();
	}

	private void setPermissions() {
		for (RecordPermission t : shopApplication.getPermissions()) {
			if (t.getTableName().equals(Tables.Supplies.TABLE_NAME)) {
				deleteOK = t.isDeletable();
				insertOK = t.isInsertable();
				updateOK = t.isUpdatable();
			}
		}

	}

	public void initUI() {
		suppliesUI = new SuppliesUI(this);

		uiContainer.initUI(suppliesUI);

	}

	public static SuppliesModule getSuppliessModule(ShopApplication shopApplication) throws Exception {
		if (shopApplication == null) {
			throw new Exception("No Main application provided!");
		} else {
			if (suppliesModule == null) {
				suppliesModule = new SuppliesModule(shopApplication);
			}
			return suppliesModule;
		}
	}

	public void setModuleListener(ModuleListener moduleListener) {
		this.moduleListener = moduleListener;
	}

	public List<Supplies> getUpdatedSuppliesList() {
		try {
			return Factory.getInstance().getSuppliesDAO().getAllSupplies();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

	public void closeGUI() {
		if (suppliesUI != null) {
			suppliesUI.setActionUIListener(null);
			uiContainer.clearUI(suppliesUI);
			suppliesUI = null;
		}

	}

	@Override
	public void doAction(int command, Object value) {
		switch (command) {
		case CMD_EXIT: {
			closeGUI();
			if (moduleListener != null) {
				moduleListener.callModule(ShopApplication.MODULE_ACTION);
			}

			break;
		}
		case CMD_SEARCH_ITEM: {

			break;
		}
		case CMD_ADD_ITEM: {
			try {
				Factory.getInstance().getSuppliesDAO().addSupplies((Supplies) value);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}
		case CMD_DELETE_ITEM: {
			try {
				Factory.getInstance().getSuppliesDAO().deleteSupplies((Supplies) value);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}
		case CMD_UPDATE_ITEM: {
			try {
				Factory.getInstance().getSuppliesDAO().updateSupplies((Supplies) value);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}
		case CMD_GET_FULL_ITEM_BY_ID: {
			try {
				supply=Factory.getInstance().getSuppliesDAO().getSuppliesById((Integer)value);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}
		default:
			break;
		}

	}

	public boolean isDeleteOK() {
		return deleteOK;
	}

	public boolean isInsertOK() {
		return insertOK;
	}

	public boolean isUpdateOK() {
		return updateOK;
	}
	
	public Supplies getSupply() {
		return supply;
	}

}
