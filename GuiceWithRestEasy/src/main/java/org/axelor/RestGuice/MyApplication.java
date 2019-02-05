package org.axelor.RestGuice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("app")

public class MyApplication extends Application{
	
	public Set<Object> singletons = new HashSet<Object>();
	
	public MyApplication()  {
		singletons.add(new RestEasyImpl());
	}
	
	@Override
	public Set<Object> getSingletons() {
		// TODO Auto-generated method stub
		return singletons;
	}

}
