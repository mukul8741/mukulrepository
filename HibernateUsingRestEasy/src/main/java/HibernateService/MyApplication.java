package HibernateService;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest1")
public class MyApplication extends Application{
	private Set<Object> singletons = new HashSet<Object>();
	
	public MyApplication() {
		singletons.add(new NameRegistery());
		//singletons.add(new AppleService());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
