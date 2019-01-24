package associationAndMapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import collection.mapping.Answer;
import collection.mapping.Question;

public class StoreData {
	public static void main(String[] args) {
		Configuration cfg=new Configuration(); 
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Book.class);
		cfg.configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties());
		

        SessionFactory sessionFactory = cfg.buildSessionFactory(builder.build());
        Session session = sessionFactory.openSession();
        
        Transaction t1 = session.beginTransaction();

        Book b1 = new Book();
        b1.setBookid(11);
        b1.setBookname("Science");
        
        List<Book> bok1 = new ArrayList();
        bok1.add(b1);
        
        Student stud1 = new Student();
        stud1.setClasse("12th");
        stud1.setId(1);
        stud1.setName("Piyush");
        stud1.setBookname(bok1);
        
        session.save(stud1);
        
        t1.commit();
        session.close();
        
    }

}
