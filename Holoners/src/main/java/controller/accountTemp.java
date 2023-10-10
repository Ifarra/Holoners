package controller;

import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import model.accountDAO;



@ManagedBean(name=("acctemp"))
@SessionScoped
public class accountTemp {

	private account talent;
	private List<account> temp;
	
	
	
	public account getTalent() {
		return talent;
	}



	public void setTalent(account talent) {
		this.talent = talent;
	}



	public List<account> getTemp() {
		return temp;
	}



	public void setTemp(List<account> temp) {
		this.temp = temp;
	}


	public void modify() {
      	accountDAO accdao = new accountDAO();
      	accdao.updateacc(talent);
     
	}

	public void selectRowById(String id) {
        // Initialize Hibernate session
        try {
        	Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(account.class);
     		// Create a SessionFactory
     		SessionFactory sf = configuration.buildSessionFactory();
     	        
     		// Open a session
     		Session session = sf.openSession(); 
            Query<account> query = session.createQuery("FROM account t WHERE t.email = :selectedId", account.class);
            query.setParameter("selectedId", id);

            // Execute the query and get the result
            talent = query.uniqueResult();

            if (talent == null) {
                // Handle the case when no matching row is found
                talent = new account();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
