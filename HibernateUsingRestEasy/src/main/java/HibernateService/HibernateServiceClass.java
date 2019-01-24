package HibernateService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hibernatePOJO.Student;


public class HibernateServiceClass {
	public static void main(String[] args) {
		Configuration cfg=new Configuration(); 
		cfg.addAnnotatedClass(Student.class);
		cfg.configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
	            .applySettings(cfg.getProperties());
		

	    SessionFactory sessionFactory = cfg.buildSessionFactory(builder.build());
	    Session session = sessionFactory.openSession();
	    
	    Transaction t1 = session.beginTransaction();

		Student student = new Student();
		
		student.setMarks(90);
		student.setName("mukul");
		student.setStdId(1);
		
		session.save(student);
		System.out.println(student.getMarks());
		System.out.println(student.getName());
		
		t1.commit();
	}
	

}
