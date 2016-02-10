package application;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import gui.LoginUI;
import gui.UIContainer;
import util.HibernateUtil;

public class LoginModule implements LoginUIListener {
	// private String login;
	// private String pass;
	private UIContainer uiContainer;
	private static LoginModule loginModule;
	private LoginUI loginUI;
	private ShopApplication shopApplication;
	private ModuleListener moduleListener;

	private LoginModule(ShopApplication shopApplication) {
		this.shopApplication = shopApplication;
		this.uiContainer = shopApplication.getUIContainer();
		moduleListener = ((ModuleListener) shopApplication);
	}

	public void initUI() {
		loginUI = new LoginUI();
		loginUI.setLoginUIListener(this);
		uiContainer.initUI(loginUI);

	}

	public static LoginModule getLoginModule(ShopApplication shopApplication) throws Exception {
		if (shopApplication == null) {
			throw new Exception("No Main application provided!");
		} else {
			if (loginModule == null) {
				loginModule = new LoginModule(shopApplication);
			}
			return loginModule;
		}
	}

	@Override
	public void doLogin(String login, String pass) {
		if (HibernateUtil.getAuthSessionFactory(login, pass) != null) {
			loginUI.showMessage("Connection success!");
			shopApplication.setLogin(login);
			shopApplication.setPassword(pass);
			setPermissions();
			closeGUI();
			if (moduleListener != null) {
				moduleListener.callModule(ShopApplication.MODULE_ACTION);
			}
		} else {
			loginUI.showMessage("Connection refused!");

		}

	}

	private void setPermissions() {
		String sqlGrants="SHOW GRANTS";
		String sqlTables="SHOW TABLES";
		String temp;
		List<String> tables;
		List<String> grants;
		Session session=null;
		RecordPermission permissions[];
		
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			tables = session.createSQLQuery(sqlTables).list();
			permissions=new RecordPermission[tables.size()];
			grants=session.createSQLQuery(sqlGrants).list();
		
			for (int i = 0; i < permissions.length; i++) {				
				permissions[i]=new RecordPermission();
				permissions[i].setTableName(tables.get(i));
				for(String s: grants){
					if(s.contains(tables.get(i))){
						if(s.contains("SELECT")){permissions[i].setSelectable(true);}
						if(s.contains("INSERT")){permissions[i].setInsertable(true);}
						if(s.contains("UPDATE")){permissions[i].setUpdatable(true);}
						if(s.contains("DELETE")){permissions[i].setDeletable(true);}
					}
				}
			}
		shopApplication.setPermissions(permissions);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}

		
		
	}

	public void setModuleListener(ModuleListener moduleListener) {
		this.moduleListener = moduleListener;
	}

	private void closeGUI() {
		if (loginUI != null) {
			loginUI.setLoginUIListener(null);
			uiContainer.clearUI(loginUI);
			loginUI = null;
		}
	}

}
