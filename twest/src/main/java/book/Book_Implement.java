package book;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Book_Implement {
	public static void main(String args[]) {
//	 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
//     Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
//	 Session session = meta.buildSessionFactory().openSession();
//     Transaction t = session.beginTransaction(); 
//		
		 Configuration cfg=new Configuration(); 
		 cfg.addAnnotatedClass(Book.class);
		 cfg.configure();
		 
//		 Configuration configuration = new Configuration().addResource("hibernate.cfg.xml").configure();
//		 
		 StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
		                 .applySettings(cfg.getProperties());
		
		 SessionFactory sessionFactory = cfg.buildSessionFactory(builder.build());
		 Session session = sessionFactory.openSession();
		 
         Transaction t1 = session.beginTransaction();
		 
		 /** logic to add */
     
		 Location loc = new Location("Mumbai","India");
		 
		 Location loc1 = new Location("Delhi","India");
		 
       Book b1 = new Book(96, "NCRT English", "40",loc,loc1);

     
       session.save(b1);
		 
//		 Book b1 = new Book();
		 
     
         t1.commit();
         System.out.println("Success");
         session.close();
	}
     
}
