package com.javacodegeeks.enterprise.rest.resteasy;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/xmlServices")
public class JerseyRestService {

	@GET
	@Path("/print/{name}")
	@Produces("application/xml")
	public Student uploadFile(@PathParam("name") String name) {

		Student st = new Student(name, "Diaz",16,5);

		return st;
	}

}