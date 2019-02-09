package org.axelor.guice.modules;

import javax.persistence.EntityManager;

import org.axelor.guice.services.GuiceJpaService;
import org.axelor.restEasy.services.RestService;
import org.jboss.resteasy.plugins.guice.RequestScoped;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class BindingModule extends AbstractModule{
	
	@Override
	protected void configure() {
		
		bind(RestService.class);
		bind(GuiceJpaService.class);
	}

}
