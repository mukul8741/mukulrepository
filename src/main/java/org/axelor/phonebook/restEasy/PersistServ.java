package org.axelor.phonebook.restEasy;

import com.google.inject.Injector;
import com.google.inject.persist.PersistService;

public class PersistServ {
	
	public PersistServ(Injector inject) {
		PersistService ps = inject.getInstance(PersistService.class);
		ps.start();
	}
	
}
