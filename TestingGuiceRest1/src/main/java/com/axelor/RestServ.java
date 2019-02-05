package com.axelor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.axelor.pojo.Car;
import org.axelor.pojo.Vehicle;

//import com.axelor.binding.HibernateImpl;
import com.google.inject.Inject;

@Path("")
public class RestServ {
	
	@Inject
	public Vehicle vehicle;
	
	@GET
	@Path("Hello")
	public void save() {
		
		vehicle.tyres();
		
		
	}

}
