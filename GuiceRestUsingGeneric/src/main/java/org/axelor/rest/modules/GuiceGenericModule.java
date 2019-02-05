package org.axelor.rest.modules;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.jpa.JpaPersistModule;

//import com.google.inject.persist.PersistService;
//import com.google.inject.persist.jpa.JpaPersistModule;

public class GuiceGenericModule extends GuiceResteasyBootstrapServletContextListener{
	
	@Override
	protected List<? extends Module> getModules(ServletContext context) {
		return Arrays.asList(new BindingModule());
	}
	
	@Override
	protected void withInjector(Injector injector) {
		injector = Guice.createInjector(new BindingModule());
	}
	
}
