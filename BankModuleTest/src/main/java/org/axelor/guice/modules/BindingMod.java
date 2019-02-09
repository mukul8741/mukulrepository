package org.axelor.guice.modules;

import com.google.inject.AbstractModule;

public class BindingMod extends AbstractModule{
	
	@Override
	protected void configure() {
		
		bind(RestService.class);
		
	}

}
