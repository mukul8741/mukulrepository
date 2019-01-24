package HibernateService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hibernatePOJO.Student;

public class SessionClass {
	
	public SessionClass(){
		
	}
	
	public Session SessionObj() {
		Configuration cfg=new Configuration(); 
		cfg.addAnnotatedClass(Student.class);
		cfg.configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
	            .applySettings(cfg.getProperties());
		

	    SessionFactory sessionFactory = cfg.buildSessionFactory(builder.build());
	    Session session = sessionFactory.openSession();
	    
	    return session;
	}

}
