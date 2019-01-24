package collectionPractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SaveData {
	public static void main(String[] args) {
		Configuration cof = new Configuration();
		cof.addAnnotatedClass(ListCollection.class);
//		cof.addAnnotatedClass(thoughts.class);
		cof.configure();
		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(cof.getProperties());

        SessionFactory sessionFactory = cof.buildSessionFactory(builder.build());
        Session session = sessionFactory.openSession();

        Transaction t2 = session.beginTransaction();
        
        
        List<String> list = new ArrayList<String>();
        
        
        ListCollection l2 = new ListCollection();

      
        /** INSERT CODE */
//        List<String> list1 = new ArrayList<String>(Arrays.asList("I am Hard Working" , "I am Simple Man"));
//        ListCollection l1 = new ListCollection();
//
//        l1.setId(2);
//        l1.setName("Mukul");
//        l1.setThoughts(list1);
//        
//        session.save(l1);
//        
//        t2.commit();
        
        
        /** FETCH CODE */
        
        l2 = session.get(ListCollection.class,21);
        
        System.out.println(l2.getId());
        System.out.println(l2.getName());
        
        list = l2.getThoughts();
        
        System.out.println(list.get(0));
        System.out.println(list.get(1));



        
        
        session.close();
        
        
	}
	

}
