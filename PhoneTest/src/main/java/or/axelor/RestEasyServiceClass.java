package or.axelor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("")
public class RestEasyServiceClass {
	
	@Context 
	HttpServletRequest request;
	
	@GET
	@Path("hello")
	public void hello() {
		
		HttpSession session = request.getSession();
		
		System.out.println(session.getAttribute("id"));
		System.out.println(session.getAttribute("sub"));


	}
	
}
