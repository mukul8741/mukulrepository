package collection.mapping;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class FetchData {
	public static void main(String[] args) {
		Configuration cfg=new Configuration(); 
		cfg.addAnnotatedClass(Question.class);
		cfg.addAnnotatedClass(Answer.class);
		cfg.configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties());
		

        SessionFactory sessionFactory = cfg.buildSessionFactory(builder.build());
        Session session = sessionFactory.openSession();

        TypedQuery query=session.createQuery("from Question");    
        List<Question> list=query.getResultList();    
            
        Iterator<Question> itr=list.iterator();    
        while(itr.hasNext()){    
            Question q=itr.next();    
            System.out.println("Question Name: "+q.getQname());    
                
            //printing answers    
            List<Answer> list2=q.getAnswers();    
            Iterator<Answer> itr2=list2.iterator();    
           while(itr2.hasNext())  
           {  
            Answer a=itr2.next();  
                System.out.println(a.getAnswername()+":"+a.getPostedBy());  
            }    
        }  
        
        
	}
}


