package org.axelor.phonebook.guice;

import javax.persistence.EntityManager;

import org.axelor.phonebook.pojo.MobileNo;
import org.axelor.phonebook.pojo.Namefor;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class GuiceService {
	
	@Inject
	public EntityManager em;
	
	@Transactional
	public void save(Object user) {
		em.persist(user);
	}

	@Transactional
	public void remove(int id) {
		Namefor name = em.find(Namefor.class,id);
		
		em.remove(name);
	}

	public void updat(int id,int number) {
		
		Namefor name = em.find(Namefor.class,id);
		
		MobileNo numb = new MobileNo();
		numb.setNumber(number);
		
		name.getNumber().add(numb);
		
		save(name);
		
	}

}
