package com.axelor.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/piyush")
public class MyApp  extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public MyApp() {
		singletons.add(new NameRegister());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}