package org.axelor.phonebook.guice;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class GuiceService {
	
	@Inject
	public EntityManager em;
	
	@Transactional
	public void save(Object user) {
		em.persist(user);
	}

}
