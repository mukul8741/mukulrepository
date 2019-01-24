package book;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class FetchData {
	public static void main(String[] args) {
		Configuration cfg=new Configuration(); 
		cfg.addAnnotatedClass(Book.class);
		//cfg.addAnnotatedClass(Answer.class);
		cfg.configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties());

        SessionFactory sessionFactory = cfg.buildSessionFactory(builder.build());
        Session session = sessionFactory.openSession();

        //Transaction t1 = session.beginTransaction();
        
        Book ques = session.get(Book.class, 96);
        
        System.out.println(ques.name);
        //System.out.println(ques.getAnswers());
        
        
	}

}
