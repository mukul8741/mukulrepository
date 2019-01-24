package table.per.subclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import book.Book;

public class StoreData {
	public static void main(String args[]) {
		Configuration cfg=new Configuration(); 
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Contract_Employee.class);
		cfg.addAnnotatedClass(Permanent.class);
		cfg.configure();
		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                 .applySettings(cfg.getProperties());

        SessionFactory sessionFactory = cfg.buildSessionFactory(builder.build());
        Session session = sessionFactory.openSession();
	          
	         Transaction t=session.beginTransaction();    
	            
	            Employee e1=new Employee("Gaurav Chawla");      
	                
	            Permanent e2=new Permanent("Mukul",10000,5000);    
	            
	            Contract_Employee e3=new Contract_Employee("Arjun Kumar",1000,15 );    
	          
	            session.persist(e1);    
	            session.persist(e2);    
	            session.persist(e3);    
	                
	            t.commit();    
	            session.close();    
	            System.out.println("success");    
	            
	    }  

}
