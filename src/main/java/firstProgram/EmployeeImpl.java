package firstProgram;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employee")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class EmployeeImpl {
	private static Map<Integer,Employee> emps = new HashMap<Integer,Employee>();
	
	
	@GET
	@Path("/fake")
	public void fake() {
		System.out.println("hello");
	}
	
	@POST
	@Path("/add")
	public Response addEmployee(Employee e) {
		GenericResponse response = new GenericResponse();
		
		if(emps.get(e.getId()) != null) {
			response.setStatus(false);
			response.setMessage("Employee already exist");
			response.setErrorCode("EC-01");
			
			return Response.status(422).entity(response).build();
			
		} else {
			emps.put(e.getId(), e);
			response.setMessage("Employee Added");
			response.setStatus(true);
			
			return Response.ok(response).build();
		}
	}
	
	@DELETE
	@Path("/{id}/delete")
	public Response deleteEmployee(@PathParam("id") int id) {
		GenericResponse response = new GenericResponse();
		
		if(emps.get(id) != null) {
			emps.remove(id);
			response.setMessage("Deleted Successfully");
			response.setStatus(true);
			
			return Response.ok(response).build();
			
		} else {
			response.setErrorCode("EC-02");
			response.setMessage("Employee Does not Exist");
			response.setStatus(false);
			
			return Response.status(404).entity(response).build();
		}
	}

}
