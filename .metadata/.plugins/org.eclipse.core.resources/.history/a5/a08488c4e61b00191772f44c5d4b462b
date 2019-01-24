package com.axelor.hibernate;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Path("/pass")
public class NameRegister {

		
	@Path("/resource")
	@GET
	@Consumes("application/x-www-form-urlencoded")
	public void addName(@QueryParam("name") String name, @QueryParam("id") int id, @QueryParam("marks")int marks) {
		
		Session session = new  StoreData().sessionObj();
		
		Transaction t = session.beginTransaction();
		Student stu = new Student();
		
		stu.setId(id);
		stu.setMakrs(marks);
		stu.setName(name);
		
		session.save(stu);
		t.commit();
		
		
	}
	
	
}
