package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Factory;
import dao.GoodsDAO;
import gui.GoodsUI;
import gui.UIContainer;
import logic.Goods;
import logic.Tables;

public class GoodsModule implements ActionUIListener {
	public static final int CMD_EXIT = 0;
	public static final int CMD_SEARCH_ITEM = 1;
	public static final int CMD_ADD_ITEM = 2;
	public static final int CMD_DELETE_ITEM = 3;
	public static final int CMD_UPDATE_ITEM = 4;

	private UIContainer uiContainer;
	private static GoodsModule goodsModule;
	private GoodsUI goodsUI;
	private List<Goods> goods = new ArrayList<>();
	private Goods pdoduct;
	private boolean insertOK;
	private boolean updateOK;
	private boolean deleteOK;

	private ShopApplication shopApplication;
	private ModuleListener moduleListener;

	private GoodsModule(ShopApplication shopApplication) {
		this.shopApplication = shopApplication;
		this.uiContainer = shopApplication.getUIContainer();
		moduleListener = ((ModuleListener) shopApplication);
		setPermissions();
	}

	private void setPermissions() {
		for (RecordPermission t : shopApplication.getPermissions()) {
			if (t.getTableName().equals(Tables.Goods.TABLE_NAME)) {
				deleteOK = t.isDeletable();
				insertOK = t.isInsertable();
				updateOK = t.isUpdatable();
			}
		}

	}

	public void initUI() {
		goodsUI = new GoodsUI(this);

		uiContainer.initUI(goodsUI);

	}

	public static GoodsModule getGoodsModule(ShopApplication shopApplication) throws Exception {
		if (shopApplication == null) {
			throw new Exception("No Main application provided!");
		} else {
			if (goodsModule == null) {
				goodsModule = new GoodsModule(shopApplication);
			}
			return goodsModule;
		}
	}

	public void setModuleListener(ModuleListener moduleListener) {
		this.moduleListener = moduleListener;
	}

	public List<Goods> getUpdatedGoodsList() {
		try {
			return Factory.getInstance().getGoodsDAO().getAllGoods();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

	public void closeGUI() {
		if (goodsUI != null) {
			goodsUI.setActionUIListener(null);
			uiContainer.clearUI(goodsUI);
			goodsUI = null;
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
				Factory.getInstance().getGoodsDAO().addGoods((Goods) value);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}
		case CMD_DELETE_ITEM: {
			try {
				Factory.getInstance().getGoodsDAO().deleteGoods((Goods)value);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}
		case CMD_UPDATE_ITEM: {
			try {
				Factory.getInstance().getGoodsDAO().updateGoods((Goods)value);
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

}
