package org.axelor.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("app")
public class MyApp extends Application{
	
	public Set<Object> singletons = new HashSet<Object>();
	
	public MyApp() {
		singletons.add(new RestEasyImpl());
	}
	
	public Set<Object> getSingletons() {
		return singletons;
	}

}
