package org.example;

import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;   
  

public class Main_class {
	public static void main(String args[]) {
		//StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	//    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build(); 
		
		//SessionFactory factory = meta.getSessionFactoryBuilder().build();  
	   // Session session = factory.openSession(); 
	    
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();


		 
		 
		
		Student student = new Student();
		
		student.setMarks(900);
		student.setName("Mukul");
		student.setPercent(90);
		student.setRollno(57);
		
		Transaction tran = session.beginTransaction();
		
		session.save(student);
		
		tran.commit();
		
		
 
	}

}

