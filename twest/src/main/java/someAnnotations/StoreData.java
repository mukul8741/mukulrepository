package someAnnotations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hqlPractise.ClassTeacher;
import hqlPractise.Student;

public class StoreData {
public static void main(String[] args) {
	Configuration  cfg = new Configuration();
	cfg.addAnnotatedClass(FormulaAnnotation.class);
	cfg.configure();
	
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
	
	SessionFactory factory = cfg.buildSessionFactory(builder.build());
	
	Session session = factory.openSession();
	
	Transaction t1 = session.beginTransaction();
	
	FormulaAnnotation fa = new FormulaAnnotation();
	FormulaAnnotation fa1 = new FormulaAnnotation();

	
	fa.setAmount(5000);
	fa.setId(1);
	fa.setName("piyush");
	
	session.save(fa);
	
	t1.commit();
	
	fa1 = session.get(FormulaAnnotation.class, 1);
    
	
	System.out.println(fa1.getDiscount());
	System.out.println(fa1.getNetAmount());
	session.close();
	
}

}
