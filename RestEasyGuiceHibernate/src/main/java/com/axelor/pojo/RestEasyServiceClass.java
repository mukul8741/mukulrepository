package com.axelor.pojo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.common.net.MediaType;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

@Path("")
public class RestEasyServiceClass {
	
	HttpServletResponse resp;
	
	@POST 
	@Path("save")
	@Consumes("application/x-www-form-urlencoded")
	
	/**
	 * The below method should be public other "not found error" will come...
	 */
	
	public Response save(@FormParam("name") String name,@FormParam("id") int id,@FormParam("clas") int clas,@FormParam("age") int age) 
			throws IOException {
		
//	    Response response;
		
		Injector injector = Guice.createInjector(new JpaPersistModule("testDB"));
		
		PersistService ps = injector.getInstance(PersistService.class);
		ps.start();
		
		ServiceImpl impl = injector.getInstance(ServiceImpl.class);
		
		Game game = new Game();
		game.setCoach("P.Shekhawat");
		game.setId(1);
		game.setName("Cricket");
		
		List<Game> ls = new ArrayList<Game>();
		ls.add(game);
		
		Student stud = new Student();
		stud.setAge(age);
		stud.setClas(clas);
		stud.setId(id);
		stud.setName(name);
		stud.setGame(ls);
		
		impl.saveStudent(stud);
		
//		resp.getWriter().println("Done");
		
//		try {
//			resp.sendRedirect("http://localhost:8080/RestEasyGuiceHibernate/index1.html");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("\n ERROR IN RESPONSE");
//		}
		
//		System.out.println("Done");
		
		URI location = null;
		try {
			location = new URI("http://localhost:8080/RestEasyGuiceHibernate/index1.html");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.temporaryRedirect(location).build();
				
		
	}
	

}
