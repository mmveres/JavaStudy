package newsdb.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import newsdb.logic.Article;
import newsdb.logic.Category;

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
	 
	        Category category = new Category("Hibernate Framework");
	 
	        Article articleOne = new Article("One-to-One Mapping",
	                "One-to-One XML Mapping Tutorial", "Hibernate,One-to-One",
	                "Content of One-to-One XML Mapping Tutorial");
	        Article articleTwo = new Article("One-to-Many Mapping",
	                "One-to-Many XML Mapping Tutorial", "Hibernate,One-to-Many",
	                "Content of One-to-Many XML Mapping Tutorial");
	        Article articleThree = new Article("Many-to-Many Mapping",
	                "Many-to-Many XML Mapping Tutorial", "Hibernate,Many-to-Many",
	                "Content of Many-to-Many XML Mapping Tutorial");
	 
	        Set<Article> articles = new HashSet<Article>();
	        articles.add(articleOne);
	        articles.add(articleTwo);
	        articles.add(articleThree);
	 
	        category.setArticles(articles);
	 
	        session.save(category);
	 
	        session.getTransaction().commit();
	        session.close();
	    }
}
