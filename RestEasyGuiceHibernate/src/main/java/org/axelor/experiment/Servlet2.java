package org.axelor.experiment;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("servlet2")
public class Servlet2 extends HttpServlet{
	
	
	@POST 
	@Path("save")
	@Consumes("application/x-www-form-urlencoded")
	
	public void save(@FormParam("name") String name,@FormParam("id") int id,@FormParam("clas") int clas,@FormParam("age") int age) {
		
		System.out.println(name);
		System.out.println(id);
		System.out.println(age);
		System.out.println(clas);
		
		
		
	}
	
	@Path("ind")
	
	public ResponseBuilder dGet(HttpServletRequest req, HttpServletResponse resp) 
			throws javax.servlet.ServletException ,java.io.IOException {
		
		resp.sendRedirect("index1.html");
		
		URI location = null;
		try {
			location = new URI("index1.html");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.temporaryRedirect(location);
		
	}

}
