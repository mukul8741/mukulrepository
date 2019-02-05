package org.axelor.rest.modules;

import org.axelor.rest.classes.Details;
import com.google.inject.Module;
import org.axelor.rest.classes.Male;
import org.axelor.rest.services.RestService;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;

public class BindingModule implements Module{ 
	
	@Override
	public void configure(Binder binder) {
		
		binder.bind(RestService.class);
		binder.bind(Details.class).to(Male.class);
		
	}
	

}
