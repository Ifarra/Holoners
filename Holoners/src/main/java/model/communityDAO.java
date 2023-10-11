package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import controller.community;

@SuppressWarnings("deprecation")
public class communityDAO {

	@SuppressWarnings("unchecked")
	public List<community> ambildatasemuanya(){
    	List<community> guh = new ArrayList<community>();
    	// Open the Configuration
    	 		Configuration configuration = new Configuration()
    	                 .configure("hibernate.cfg.xml")
    	                 .addAnnotatedClass(community.class);
    		  // Create a SessionFactory
    	      SessionFactory sf = configuration.buildSessionFactory();
    	  	        
    	      // Open a session
    	      Session session = sf.openSession(); 
    	      
    	      // Begin a transaction
    	      Transaction tx = session.beginTransaction();
    	      
    	      Query<community> query = session.createQuery("FROM community");

    	      
    	      guh = query.list();
    	      
    	      tx.commit();
    	      
    	      sf.close();
    	      
    	      return guh;
    	      
    }
	
	public void savecommunity(community acc) {
    	// Open the Configuration
 		Configuration configuration = new Configuration()
                 .configure("hibernate.cfg.xml")
                 .addAnnotatedClass(community.class);
	  // Create a SessionFactory
      SessionFactory sf = configuration.buildSessionFactory();
  	        
      // Open a session
      Session session = sf.openSession(); 
      
      // Begin a transaction
      Transaction tx = session.beginTransaction();
      
      // Save the student
      session.save(acc);
	
      // Commit the transaction
      tx.commit();

      // Close the SessionFactory
      sf.close();
      
      System.out.println("CLEAR");
    }
	
	public void updatecommunity(community acc) {
    	// Open the Configuration
 		Configuration configuration = new Configuration()
                 .configure("hibernate.cfg.xml")
                 .addAnnotatedClass(community.class);
	  // Create a SessionFactory
      SessionFactory sf = configuration.buildSessionFactory();
  	        
      // Open a session
      Session session = sf.openSession(); 
      
      // Begin a transaction
      Transaction tx = session.beginTransaction();
      
      // Save the student
      session.update(acc);
	
      // Commit the transaction
      tx.commit();

      // Close the SessionFactory
      sf.close();
      
      System.out.println("CLEAR");
    }
	
@SuppressWarnings("removal")
public void deleteCommunity(String id) {
		
		Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(community.class);
	  // Create a SessionFactory
     SessionFactory sf = configuration.buildSessionFactory();
 	        
     // Open a session
     Session session = sf.openSession(); 
     
     // Begin a transaction
     Transaction tx = session.beginTransaction();
     community acc = (community)session.load(community.class, new Integer(Integer.valueOf(id)));
     session.delete(acc);
     tx.commit();
     sf.close();
	}
	
}
