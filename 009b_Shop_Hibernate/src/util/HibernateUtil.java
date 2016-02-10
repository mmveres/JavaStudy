package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;

	static {

	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// creates the session factory from hibernate.cfg.xml
				sessionFactory = new Configuration().configure().buildSessionFactory();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return sessionFactory;
	}

	public static SessionFactory getAuthSessionFactory(String login, String password) {
		closeSessionFactory();
		sessionFactory = null;
		try {
			Configuration cfg = new Configuration();
			cfg.configure();
			cfg.setProperty("hibernate.connection.password", password);
			cfg.setProperty("hibernate.connection.username", login);
			sessionFactory = cfg.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			return sessionFactory;
		}
		
	}

	public static void closeSessionFactory() {
		if (sessionFactory!=null&&!sessionFactory.isClosed())
			sessionFactory.close();
	}

}
