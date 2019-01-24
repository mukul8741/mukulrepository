package org.axelor.webAppUsingServlet;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.spi.HttpResponse;

import com.axelor.pojo.Game;
import com.axelor.pojo.ServiceImpl;
import com.axelor.pojo.Student;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

@Path("servlet")
public class Servlet1 extends HttpServlet{
	
	
	@POST 
	@Path("save")
	@Consumes("application/x-www-form-urlencoded")
	
	/**
	 * The below method should be public other "not found error" will come...
	 */
	public void save(@FormParam("name") String name,@FormParam("id") int id,@FormParam("clas") int clas,@FormParam("age") int age) 
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
		
        System.out.println("Done");
        
        URI uri = null;
		try {
			uri = new URI("http://localhost:8080/RestEasyGuiceHibernate/index1.html");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Response.temporaryRedirect(uri);
        
       
		
//		resp.getWriter().println("Done");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect("index1.html");
		
	}
	
//	HttpServletResponse resp;
//	HttpServletRequest req;
//	
//	@POST 
//	@Path("get1")
//	@Consumes("application/x-www-form-urlencoded")
//
//	/**
//	 * The below method should be public other "not found error" will come...
//	 */
//	public void dot(@FormParam("name") String name,@FormParam("id") int id,@FormParam("clas") int clas,
//			                   @FormParam("age") int age) 
//			            		    throws ServletException, IOException {
//		
//        Injector injector = Guice.createInjector(new JpaPersistModule("testDB"));
//		
//		PersistService ps = injector.getInstance(PersistService.class);
//		ps.start();
//		
//		ServiceImpl impl = injector.getInstance(ServiceImpl.class);
//		
//		Game game = new Game();
//		game.setCoach("P.Shekhawat");
//		game.setId(1);
//		game.setName("Cricket");
//		
//		List<Game> ls = new ArrayList<Game>();
//		ls.add(game);
//		
//		Student stud = new Student();
//		stud.setAge(age);
//		stud.setClas(clas);
//		stud.setId(id);
//		stud.setName(name);
//		stud.setGame(ls);
//		
//		impl.saveStudent(stud);
//		
//		System.out.println("Done");
//		
//		String name1 = req.getParameter("name");
//		
//		resp.sendRedirect("index1.html");
//		
//	}

}
