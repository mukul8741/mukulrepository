package hqlPractise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HqlPractise {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(ClassTeacher.class);
		cfg.configure();
		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		SessionFactory factory = cfg.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		Transaction t1 = session.beginTransaction();
		
		Name studName = new Name();
		studName.firdtName = "Lokesh";
		studName.lastName = "Verma";
		
		Name teacName = new Name();
		teacName.firdtName = "Himanshu";
		teacName.lastName = "Verma";
		
		ClassTeacher teacher = new ClassTeacher();
		teacher.setClas(11);
		teacher.setContactNo("9876655432");
		teacher.setName(teacName);
		teacher.setId(2);
		
		
		Student lokesh = new Student();
//		lokesh.setClas(12);
		lokesh.setId(2);
		lokesh.setName(studName);
		lokesh.setTeacher(teacher);
		
		session.persist(lokesh);
		
		t1.commit();
		session.close();
		
				
		
		
	}

}
