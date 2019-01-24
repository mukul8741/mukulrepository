package associationAndMapping;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import collection.mapping.Answer;
import collection.mapping.Question;

public class FetchData {
	public static void main(String[] args) {
		Configuration cfg=new Configuration(); 
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Book.class);
		cfg.configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties());
		

        SessionFactory sessionFactory = cfg.buildSessionFactory(builder.build());
        Session session = sessionFactory.openSession();

        TypedQuery query=session.createQuery("from Student");
        
        Student std1 = new Student();
        Book b1 = new Book();
        
        List<Student> list = query.getResultList();
         
        Iterator<Student> itr = list.iterator();
        if(itr.hasNext()) {
        	std1 = itr.next();
        	System.out.println(std1.getId());
        	System.out.println(std1.getName());
        	System.out.println(std1.getClasse());
        	
        	b1 = (Book) std1.getBookname();
        	System.out.println(b1.getBookid());
        	System.out.println(b1.getBookname());
        	


        	
        	
        	
        }
	}
}
