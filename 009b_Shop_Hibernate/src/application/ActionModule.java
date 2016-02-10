package application;

import javax.swing.JOptionPane;

import gui.ActionUI;
import gui.LoginUI;
import gui.UIContainer;
import util.HibernateUtil;

public class ActionModule implements ActionUIListener {
	public static final int CMD_CALL_VIEW = 4;
	public static final int CMD_CALL_GOODS = 1;
	public static final int CMD_CALL_SUPPLIES = 2;
	public static final int CMD_CALL_SALES = 3;
	private UIContainer uiContainer;
	private static ActionModule actionModule;
	private ActionUI actionUI;
	private ShopApplication shopApplication;
	private ModuleListener moduleListener;

	private ActionModule(ShopApplication shopApplication) {
		this.shopApplication = shopApplication;
		this.uiContainer = shopApplication.getUIContainer();
		moduleListener = ((ModuleListener) shopApplication);
	}

	public void initUI() {
		actionUI = new ActionUI();
		actionUI.setActionUIListener(this);
		uiContainer.initUI(actionUI);

	}

	public static ActionModule getActionModule(ShopApplication shopApplication) throws Exception {
		if (shopApplication == null) {
			throw new Exception("No Main application provided!");
		} else {
			if (actionModule == null) {
				actionModule = new ActionModule(shopApplication);
			}
			return actionModule;
		}
	}

	public void setModuleListener(ModuleListener moduleListener) {
		this.moduleListener = moduleListener;
	}

	public void closeGUI() {
		if (actionUI != null) {
			actionUI.setActionUIListener(null);
			uiContainer.clearUI(actionUI);
			actionUI = null;
		}
	}

	@Override
	public void doAction(int command, Object value) {
		switch (command) {
		case CMD_CALL_GOODS: {
			
			closeGUI();
			moduleListener.callModule(ShopApplication.MODULE_GOODS);

			break;
		}
		case CMD_CALL_SUPPLIES: {
			closeGUI();
			moduleListener.callModule(ShopApplication.MODULE_SUPPLIES);

			break;
		}
		case CMD_CALL_VIEW: {
			// closeGUI();
			moduleListener.callModule(ShopApplication.MODULE_VIEW);

			break;
		}
		case CMD_CALL_SALES: {
			// closeGUI();
			moduleListener.callModule(ShopApplication.MODULE_SALES);

			break;
		}
		default:
			break;
		}

	}

}
