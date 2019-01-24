package collection.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import book.Book;

public class StoreDataQuestion {
	public static void main(String[] args) {
//		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
//	    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
//	      
//	    SessionFactory factory=meta.getSessionFactoryBuilder().build();  
//	    Session session=factory.openSession();  
//	   
//	    Transaction t=session.beginTransaction(); 
	    
	    Configuration cfg=new Configuration(); 
		cfg.addAnnotatedClass(Question.class);
		cfg.addAnnotatedClass(Answer.class);
		cfg.configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties());

        SessionFactory sessionFactory = cfg.buildSessionFactory(builder.build());
        Session session = sessionFactory.openSession();

        Transaction t2 = session.beginTransaction();
	    
        Answer ans1=new Answer();    
        ans1.setAnswername("Java is a programming language");    
        ans1.setPostedBy("Ravi Malik");    
            
        Answer ans2=new Answer();    
        ans2.setAnswername("Java is a platform");    
        ans2.setPostedBy("Sudhir Kumar");    
            
        Answer ans3=new Answer();    
        ans3.setAnswername("Servlet is an Interface");    
        ans3.setPostedBy("Jai Kumar");    
            
        Answer ans4=new Answer();    
        ans4.setAnswername("Servlet is an API");    
        ans4.setPostedBy("Arun");    
            
        ArrayList<Answer> list1=new ArrayList<Answer>();    
        list1.add(ans1);    
        list1.add(ans2);    
            
        ArrayList<Answer> list2=new ArrayList<Answer>();    
        list2.add(ans3);    
        list2.add(ans4);    
            
        Question question1=new Question();    
        question1.setQname("What is Java?");    
        question1.setAnswers(list1);    
            
        Question question2=new Question();    
        question2.setQname("What is Servlet?");    
        question2.setAnswers(list2);    
            
        session.persist(question1);    
        session.persist(question2);    
            
        t2.commit();    
        session.close();    
        System.out.println("success");    
      
	}
	
}
