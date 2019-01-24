package multipleTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class StoreData {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Book.class);
		cfg.configure();
		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		
		SessionFactory sf = cfg.buildSessionFactory(builder.build());
		
		Session session = sf.openSession();
		
		Transaction t1 = session.beginTransaction();


		Book b1 = new Book(4,"NCERT SCIENCE",200);
		
		session.persist(b1);
		
		t1.commit();
		
        session.close();
		
		
	}

}
