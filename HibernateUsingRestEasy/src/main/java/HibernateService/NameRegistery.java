package HibernateService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernatePOJO.Student;

@Path("pass")
public class NameRegistery {
	
	@Path("resource")
	@GET
	@Consumes("application/x-www-form-urlencoded")
	public void addName(@QueryParam("name") String name, @QueryParam("id") int id, @QueryParam("marks") int marks) {
		System.out.println(1111);
		
		Session session = new SessionClass().SessionObj();
		
		Transaction t1 = session.beginTransaction();
		
        Student student = new Student();
		
		student.setMarks(marks);
		student.setName(name);
		student.setStdId(id);
		
		session.save(student);
		
		t1.commit();
		
	}

}
