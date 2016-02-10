package application;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import gui.UIContainer;

public class ShopApplication implements ModuleListener {
	private String login;
	private String password;
	private static ShopApplication shopApplication;
	private UIContainer uiContainer;
	public static final int MODULE_LOGIN = 1;
	public static final int MODULE_ACTION = 2;
	public static final int MODULE_GOODS = 3;
	public static final int MODULE_SUPPLIES = 4;
	public static final int MODULE_VIEW = 5;
	public static final int MODULE_SALES = 6;
	private RecordPermission[] permissions;
	private GoodsModule goodsModule;
	private SuppliesModule suppliesModule;

	private ShopApplication() {

	}

	public static ShopApplication getShopApplication() {
		if (shopApplication == null) {
			shopApplication = new ShopApplication();
		}
		return shopApplication;
	}

	public void start() {
		initMainUI();
		while (uiContainer == null) {
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		initLogin();
	}

	private void initLogin() {
		try {
			LoginModule.getLoginModule(this).initUI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void initMainUI() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				uiContainer = new UIContainer();

			}
		});

	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UIContainer getUIContainer() {
		return uiContainer;
	}

	@Override
	public void callModule(int moduleID) {
		switch (moduleID) {
		case MODULE_ACTION: {
			try {
				System.out.println("MODULE_ACTION");
				ActionModule.getActionModule(this).initUI();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		}
		case MODULE_GOODS: {
			try {
				goodsModule = GoodsModule.getGoodsModule(this);
				goodsModule.initUI();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		}
		case MODULE_SUPPLIES: {
			try {
				suppliesModule=SuppliesModule.getSuppliessModule(this);
				suppliesModule.initUI();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		}
		case MODULE_VIEW: {
			try {
				System.out.println("view called");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		}
		case MODULE_SALES: {
			try {
				System.out.println("sales called");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		}
		default:
			break;
		}

	}

	public void setPermissions(RecordPermission[] permissions) {
		this.permissions = permissions;
	}

	public RecordPermission[] getPermissions() {
		return permissions;
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		// only got here if we didn't return false
		return true;
	}

	public static boolean isValidDate(String dateString) {
		SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
		boolean valid = false;
		try {
			df.parse(dateString);
			valid = true;
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (java.text.ParseException e) {

		}
		return valid;
	}

}

class RecordPermission {
	private String tableName;
	private boolean deletable;
	private boolean selectable;
	private boolean insertable;
	private boolean updatable;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public boolean isDeletable() {
		return deletable;
	}

	public void setDeletable(boolean deletable) {
		this.deletable = deletable;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public boolean isInsertable() {
		return insertable;
	}

	public void setInsertable(boolean insertable) {
		this.insertable = insertable;
	}

	public boolean isUpdatable() {
		return updatable;
	}

	public void setUpdatable(boolean updatable) {
		this.updatable = updatable;
	}

	@Override
	public String toString() {
		return "TablePermission [tableName=" + tableName + ", deletable=" + deletable + ", selectable=" + selectable
				+ ", insertable=" + insertable + ", updatable=" + updatable + "]";
	}

}
