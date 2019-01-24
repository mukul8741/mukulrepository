package pProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class StoreData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random r = new Random();
		int i = r.nextInt(1000);
		
		Laptop laptop =new Laptop();
		laptop.setLid(i);
		laptop.setLname("Dell");
		
		List<Laptop> l = new ArrayList();
		l.add(laptop);
		
		int j = r.nextInt(1000);
		
		Student student = new Student();
		student.setRollno(j);
		student.setMarks(441);
		student.setName("Piyush");
		student.setL(l);
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Laptop.class);
		cfg.configure("hibernate.cfg.xml");
		
		StandardServiceRegistryBuilder ssr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		SessionFactory sf = cfg.buildSessionFactory(ssr.build());
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();



		//session.save(laptop);
		session.save(student);
//		session.getTransaction().commit();
		t.commit();
		
	}

}