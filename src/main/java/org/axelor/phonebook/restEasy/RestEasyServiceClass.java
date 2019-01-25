package org.axelor.phonebook.restEasy;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.axelor.phonebook.guice.GuiceService;
import org.axelor.phonebook.pojo.LoginTable;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

@Path("phone")
public class RestEasyServiceClass {
	
	Injector inject = Guice.createInjector(new JpaPersistModule("testDB"));
	
	@POST
	@Path("signup")
	@Consumes("application/x-www-form-urlencoded")
	public Response signUp(@FormParam("name") String name,@FormParam("pass") String pass,@FormParam("email") String email) {
		
		PersistService ps = inject.getInstance(PersistService.class);
		ps.start();
		
		GuiceService guiceService = inject.getInstance(GuiceService.class);
		
		LoginTable signUp = new LoginTable();
		signUp.setEmail(email);
		signUp.setName(name);
		signUp.setPassword(pass);
		
		guiceService.save(signUp);
		
		URI uri = null;
		try {
			uri = new URI("http://localhost:8080/PhoneBook/app/login.html");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.temporaryRedirect(uri).build();
		
	}
	
	@POST
	@Path("login")
	@Consumes("application/x-www-form-urlencoded")
	public Response logIn(@FormParam("email") String email,@FormParam("pass") String pass) {
		
		PersistService ps = inject.getInstance(PersistService.class);
		ps.start();
		
		GuiceService guiceService = inject.getInstance(GuiceService.class);
		
		Query query = guiceService.em.createQuery("select l from LoginTable l where l.email = " 
		                                           + email + " And l.password = " + pass + "");
		List<LoginTable> logIn = (List<LoginTable>)query.getResultList();
		
		if(logIn.size() != 0) {
			
			URI uri = null;
			try {
				uri = new URI("http://localhost:8080/PhoneBook/app/phonebook.jsp");
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return Response.temporaryRedirect(uri).build();
			
		} else {
			
			URI uri = null;
			try {
				uri = new URI("http://localhost:8080/PhoneBook/app/errorLogin.html");
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return Response.temporaryRedirect(uri).build();
			
			
		}
		
		
	}

}
