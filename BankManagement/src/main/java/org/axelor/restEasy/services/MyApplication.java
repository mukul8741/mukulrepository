package org.axelor.restEasy.services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.axelor.guice.services.GuiceJpaService;

@ApplicationPath("app")
public class MyApplication extends Application{
	private Set<Object> singletons = new HashSet<Object>();

	public MyApplication() {
		singletons.add(new RestService());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
