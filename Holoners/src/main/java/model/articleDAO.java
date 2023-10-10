package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import controller.article;

@SuppressWarnings("deprecation")
public class articleDAO {

	public static List<article> getAllRecords() {
	    List<article> list = new ArrayList<article>();

	    try {
	    	Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(article.class);
     		// Create a SessionFactory
     		SessionFactory sf = configuration.buildSessionFactory();
     	        
     		// Open a session
     		Session session = sf.openSession(); 
	    	
	        Query<article> query = session.createQuery("FROM article", article.class);
	        list = query.list();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    
	    return list;
	}
	
}
