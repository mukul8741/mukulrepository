package org.axelor.phonebook.restEasy;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.axelor.phonebook.guice.GuiceService;
import org.axelor.phonebook.pojo.MobileNo;
import org.axelor.phonebook.pojo.Namefor;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

@Path("phone")
public class RestEasyServiceClass {
		
	Injector inject = Guice.createInjector(new JpaPersistModule("testDB"));
	PersistServ ps = new PersistServ(inject);
	
	@POST
	@Path("add")
	@Consumes("application/x-www-form-urlencoded")
	public Response add(@FormParam("name") String name,@FormParam("numb1") int numb) {
		
		System.out.println("1111");
		
		GuiceService guiceService = inject.getInstance(GuiceService.class);

		
		List<MobileNo> list = new ArrayList<MobileNo>();
		
		MobileNo mob = new MobileNo();
		mob.setNumber(numb);
		
//		guiceService.save(mob);
		
		list.add(mob);
		
		Namefor name1 = new Namefor();
		name1.setName(name);
		name1.setNumber(list);
		
		guiceService.save(name1);
		
		URI location = null;
		try {
			location = new URI("http://localhost:8080/PhoneBook/done.html");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.temporaryRedirect(location).build();
		
	}
	
	
	@POST
	@Path("delete")
	@Consumes("application/x-www-form-urlencoded")
	public Response delete2(@FormParam("deleteid") int id)
	{
		System.out.println(id);
     	ResponseBuilder resp = delete(id);
     	return resp.build();
	}
	
	@DELETE
	//@Consumes("application/x-www-form-urlencoded")
	public ResponseBuilder delete(int id) {
		
		GuiceService guiceService = inject.getInstance(GuiceService.class);

		
		guiceService.remove(id);
		

		URI location = null;
		try {
			location = new URI("http://localhost:8080/PhoneBook/done.html");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.temporaryRedirect(location);
	}
	
	
	@POST
	@Path("update")
	@Consumes("application/x-www-form-urlencoded")
	public Response update2(@FormParam("id") int id, @FormParam("numb") int number)
	{
	
     	ResponseBuilder resp = update(id,number);
     	return resp.build();
	}
	
	@PUT
	//@Consumes("application/x-www-form-urlencoded")
	public ResponseBuilder update(int id,int number) {
		
		GuiceService guiceService = inject.getInstance(GuiceService.class);

		
		guiceService.updat(id,number);
		

		URI location = null;
		try {
			location = new URI("http://localhost:8080/PhoneBook/done.html");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.temporaryRedirect(location);
	}	

		
		

}
