package org.axelor.guice.modules;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

public class GuiceGeneric extends GuiceResteasyBootstrapServletContextListener{
	
	@Override
	protected List<Module> getModules(ServletContext context) {
		return Arrays.asList(new JpaPersistModule("testDB"),new BindingModule());
	}

	@Override
	protected void withInjector(Injector injector) {
		
		injector.getInstance(PersistService.class).start();
		
	}
}
