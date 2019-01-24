package com.axelor.workingOne;

import com.google.inject.AbstractModule;

public class BindingModule extends AbstractModule{
	
	@Override
	protected void configure() {
		
		bind(Car.class).to(Sports.class);
		
	}
	

}
