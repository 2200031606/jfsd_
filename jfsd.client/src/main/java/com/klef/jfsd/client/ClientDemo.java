package com.klef.jfsd.client;


import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {

	public static void main(String[] args) {
//		Configuration cfg=new 
		 Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml"); // hibernate.cfg.xml should have updated mappings
	        
	        // Step 2: Build SessionFactory
	        SessionFactory sf = cfg.buildSessionFactory();
	        
	        // Step 3: Open session
	        Session s = sf.openSession();
	        
	        // Step 4: Begin transaction
	        Transaction t = s.beginTransaction();
	        
	        Client c=new Client();
	        c.setId(100);
	        c.setName("klef");
	        c.setAge(100);
	        c.setGender("Male");
	        c.setLocation("Vijayawada");
	        c.setMoblino("9182720578");
	        c.setEmail("klef@gmail.com");
	        
	        s.save(c);
	        t.commit();
	        
	        System.out.println("Inserted Successfully");
	        Query qry= s.createQuery("From Client");
	        Client cl= s.get(Client.class,2);
	        
	        if(cl !=null)
	        {
	        	System.out.println(cl.getId());
	        	System.out.println(cl.getName());
	        	System.out.println(cl.getAge());
	        	System.out.println(cl.getGender());
	        	System.out.println(cl.getLocation());
	        	System.out.println(cl.getEmail());
	        	System.out.println(cl.getMoblino());
	        }
	        s.close();
	        sf.close();
	        
	       
	        
	}

}
