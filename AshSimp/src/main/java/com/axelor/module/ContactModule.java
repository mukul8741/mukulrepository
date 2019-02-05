package com.axelor.module;

import org.axelor.guice.mukul.Details;
import org.axelor.guice.mukul.Male;

import com.axelor.service.ContactController;
import com.axelor.service.ContactService;
import com.axelor.service.ContactServiceImpl;
//import com.axelor.service.ContactServiceImpl;
import com.google.inject.AbstractModule;

public class ContactModule extends AbstractModule{
	@Override
	protected void configure() {
		bind(ContactController.class);
		bind(ContactService.class).to(ContactServiceImpl.class);
	    bind(Details.class).to(Male.class);
	}
	
}