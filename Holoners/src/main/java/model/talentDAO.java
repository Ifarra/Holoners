package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	
	@SuppressWarnings("unchecked")
	public List<talent> ambildatasemuanya(){
    	List<talent> guh = new ArrayList<talent>();
    	// Open the Configuration
    	 		Configuration configuration = new Configuration()
    	                 .configure("hibernate.cfg.xml")
    	                 .addAnnotatedClass(talent.class);
    		  // Create a SessionFactory
    	      SessionFactory sf = configuration.buildSessionFactory();
    	  	        
    	      // Open a session
    	      Session session = sf.openSession(); 
    	      
    	      // Begin a transaction
    	      Transaction tx = session.beginTransaction();
    	      
    	      Query<talent> query = session.createQuery("FROM talent");

    	      
    	      guh = query.list();
    	      
    	      tx.commit();
    	      
    	      sf.close();
    	      
    	      return guh;
    	      
    }
	
	public void savetalent(talent acc) {
    	// Open the Configuration
 		Configuration configuration = new Configuration()
                 .configure("hibernate.cfg.xml")
                 .addAnnotatedClass(talent.class);
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
	
	public void updatetalent(talent acc) {
    	// Open the Configuration
 		Configuration configuration = new Configuration()
                 .configure("hibernate.cfg.xml")
                 .addAnnotatedClass(talent.class);
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
public void deleteTalent(String id) {
		
		Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(talent.class);
	  // Create a SessionFactory
     SessionFactory sf = configuration.buildSessionFactory();
 	        
     // Open a session
     Session session = sf.openSession(); 
     
     // Begin a transaction
     Transaction tx = session.beginTransaction();
     talent acc = (talent)session.load(talent.class, new Integer(Integer.valueOf(id)));
     session.delete(acc);
     tx.commit();
     sf.close();
	}
	
}
