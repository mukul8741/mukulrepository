package org.axelor.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartInput;

@Path("")
public class RestEasyImpl {

	@Path("hello")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	
	public Student hello() {
		
		System.out.println("1111");
		
		Student std = new Student();
		std.setClas(12);
		std.setId("1");
		std.setMarks(99);
		std.setName("Mukul");
		
		return std;
		
	}
	
	/**
	 * 
	 * Here we are using both XML and JSON bindings
	 * so we will use both of their jars(JACKSON an JAXB).
	 * 
	 */
	
	@POST	
	@Path("consume")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	
	public Student consume(Student stud) {
				
		return stud;
		
	}
	
	/**
	 * MultiPart Data Handling
	 * 
	 */
	
	@Path("multipart")
	@POST
	@Consumes("multipart/form-data")
	@Produces("application/xml")
	
	public List<Student> multipart(MultipartInput input) {
		
		List<Student> list = new ArrayList<Student>();
		
		for(InputPart input1:input.getParts()) {
			
			Student stud;
			try {
				stud = input1.getBody(Student.class,null);
				list.add(stud);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		return list;
		
	}
	
}
