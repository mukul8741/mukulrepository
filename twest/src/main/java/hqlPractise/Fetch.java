package hqlPractise;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.SetOfIntegerSyntax;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

//import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Fetch {
	public static void main(String[] args) {
		Configuration  cfg = new Configuration();
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(ClassTeacher.class);
		cfg.configure();
		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		
		SessionFactory factory = cfg.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		
		Transaction t1 = session.beginTransaction();
		
//		Query query = session.createQuery("from Student s, where ClassTeacher.clas=:c");
//		query.setParameter("c",12);
//		
//		Student list = (Student) query.list().get(0);
//		
//		System.out.println(list.getId());
//		System.out.println(list.getClass());
//		System.out.println(list.getName());
//		System.out.println(list.getTeacher());
		
//		Criteria c = session.createCriteria(ClassTeacher.class);
//		c.add(Restrictions.eq("id",1));
//		c.setProjection(Projections.property("contactNo"));
		
		SQLQuery query = session.createSQLQuery("select name from table_1 where id < ? And id > ?");
		query.setInteger(1, 3);
        query.setInteger(2, 0);		
		
		List<String> list = (List<String>) query.list();
		System.out.println(list);
	}

}
