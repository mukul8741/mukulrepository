package org.axelor.RestGuice;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

/**
 * 
 * This class is used for binding the RestEasy class
 * and dependency injection
 * 
 * This program is running without the
 * GuiceResteasyBootstrapServletContextListener.class 
 * 
 * no use of dependency "compile 'org.jboss.resteasy:resteasy-guice:3.6.0.Final'"
 *
 */

public class HelloModule implements Module{

	@Override
	public void configure(final Binder binder) {
		
//		binder.bind(GuiceResteasyBootstrapServletContextListener.class);
//		binder.bind(HttpServletDispatcher.class).in(Singleton.class);
		binder.bind(RestEasyImpl.class);
		binder.bind(HelloInterface.class).to(HelloImpl.class);
		
	}

}
