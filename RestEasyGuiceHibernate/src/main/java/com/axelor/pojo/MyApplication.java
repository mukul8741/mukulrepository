package com.axelor.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.axelor.experiment.Servlet2;
import org.axelor.webAppUsingServlet.Servlet1;

@ApplicationPath("app")
public class MyApplication extends Application{
	
	public Set<Object> singletons = new HashSet<Object>();
	
	public MyApplication() {
		singletons.add(new RestEasyServiceClass());
	}
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
