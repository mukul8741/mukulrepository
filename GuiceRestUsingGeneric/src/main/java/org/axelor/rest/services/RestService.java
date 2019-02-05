package org.axelor.rest.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.axelor.rest.classes.Details;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
@Path("")
public class RestService {
	
	{
	  System.out.println("Entered Into RestService Class");
	}
	
	@Inject
	Details detail;
	
	@GET
	@Path("{name}")
//	@Produces("plain/text")
	
	public void hello(@PathParam("name") String name) {
		
		detail.name();
		detail.age();
		detail.age();
		
	}

}
