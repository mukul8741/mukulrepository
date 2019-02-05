package com.axelor.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.axelor.pojo.Contact;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

public class ContactServiceImpl implements ContactService {
	
	@Inject
	public Provider<EntityManager> provider;
	public EntityManager em;

	@Inject
	public ContactServiceImpl(EntityManager em) {
		this.em = em;
	}
	@Transactional
	@Override
	public void addcontact(Contact c) {
		em=provider.get();
		em.persist(c);
		List<Contact> contacts=viewcontact();
		System.out.println(contacts.size());
		System.err.println(contacts.toString());
	}
	@Transactional
	@Override
	public List<Contact> viewcontact() {
		em=provider.get();
		return em.createQuery("select c from Contact c").getResultList();
		//return null;
	}
	@Override
	public void deletecontact(int id) {
		
		em=provider.get();
		Contact c=em.find(Contact.class, id);
		em.remove(c);
	}
	
}