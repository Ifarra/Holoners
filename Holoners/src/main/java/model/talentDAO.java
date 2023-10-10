package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import controller.account;
import controller.talent;

@SuppressWarnings("deprecation")
public class talentDAO {

	public static List<talent> getAllRecords() {
	    List<talent> list = new ArrayList<talent>();

	    try {
	    	Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(account.class);
     		// Create a SessionFactory
     		SessionFactory sf = configuration.buildSessionFactory();
     	        
     		// Open a session
     		Session session = sf.openSession(); 
	    	
	        Query<talent> query = session.createQuery("FROM Book", talent.class);
	        list = query.list();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    
	    return list;
	}
	
}
