package someAnnotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class EnumStore {
	public static void main(String[] args) {
		Configuration  cfg = new Configuration();
		cfg.addAnnotatedClass(enuImplement.class);
		cfg.configure();
		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		
		SessionFactory factory = cfg.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		
		Transaction t1 = session.beginTransaction();
		
		enuImplement object = new enuImplement(2,"Mukul",enumExample.maxi);
		
		session.save(object);
		
		t1.commit();
		session.close();
	}

}
