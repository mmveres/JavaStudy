package personnel.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import personnel.logic.Account;
import personnel.logic.Employee;

public class Main {
	public static void main(String[] args) {
		// loads configuration and mappings
        Configuration configuration = new Configuration().configure();
 
        // builds a session factory from the service registry
        SessionFactory sessionFactory = configuration
                .buildSessionFactory();
 
        // obtains the session
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Account acc1= new Account("445566");
        Account acc2= new Account("890654");
        Set<Account> accs=new HashSet<>();
        accs.add(acc1);
        accs.add(acc2);
        
        Employee emp= new Employee("Kote",	43);
        emp.setAccounts(accs);
        session.save(emp);    
        
        
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
	}
}
