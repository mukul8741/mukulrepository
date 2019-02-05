package org.axelor.guice.mukul;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.axelor.service.ContactController;

@ApplicationPath("app")
public class MyApplication extends Application{
	public Set<Object> singletons = new HashSet<Object>();
	
	public MyApplication() {
		singletons.add(new ContactController());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
