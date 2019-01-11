package firstProgram;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class RestEasyTestClient {
	public static void main(String[] args) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		
		//POST example
				ResteasyWebTarget add = client.target("http://localhost:8080/RESTEasy/employee/add");
				Employee emp = new Employee();
				emp.setId(50);emp.setName("Rick");
				Response addResponse = add.request().post(Entity.entity(emp, MediaType.APPLICATION_XML));
				System.out.println(addResponse.readEntity(GenericResponse.class));
				System.out.println("HTTP Response Code:"+addResponse.getStatus());
				addResponse.close();
				
				addResponse = add.request().post(Entity.entity(emp, MediaType.APPLICATION_XML));
				System.out.println(addResponse.readEntity(GenericResponse.class));
				System.out.println("HTTP Response Code:"+addResponse.getStatus());
				addResponse.close();
				
		//DELETE example
				ResteasyWebTarget delete = client.target("http://localhost:8080/RESTEasy/employee/50/delete");
				Response deleteResponse = delete.request().delete();
				System.out.println(deleteResponse.readEntity(GenericResponse.class));
				System.out.println("HTTP Response Code:"+deleteResponse.getStatus());
				deleteResponse.close();
				
				deleteResponse = delete.request().delete();
				System.out.println(deleteResponse.readEntity(GenericResponse.class));
				System.out.println("HTTP Response Code:"+deleteResponse.getStatus());
				deleteResponse.close();
	}

}
