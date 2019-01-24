

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder; 
import org.hibernate.cfg.*;


public class StoreData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
         Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		
//		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	    Session session = meta.buildSessionFactory().openSession();
        Transaction t = session.beginTransaction();  
       
        Name name1 = new Name();
        name1.first = "mukul";
        name1.last = "Shekhawat";
        
        Employee e1=new Employee();    
        e1.setId(5);    
        e1.setName(name1);
      
        session.save(e1);  
        t.commit();  
        System.out.println("successfully saved");    
         
        session.close();     

	}

}
