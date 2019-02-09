package org.axelor.guice.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.axelor.pojo.Account;
import org.axelor.pojo.Transaction;
import org.jboss.resteasy.plugins.guice.RequestScoped;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

public class GuiceJpaService {
	
	
	public EntityManager em;

	@Inject
	public GuiceJpaService(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void save(Object obj) {
		em.persist(obj);
	}
	
	public void refresh(Object obj) {
		em.refresh(obj);
	}
	
	public Object find(Object obj, String id) {
		obj = em.find(obj.getClass(), id);
		em.refresh(obj);
		
		return obj;
	}
	
	public List<Account> findAccounts(String id) {
		Query query = em.createQuery("from Account a where a.user = '" + id + "'");
		
		return query.getResultList();
	}
	
	public List<Transaction> findTransaction(String account) {
		Query query = em.createQuery("from Transaction t where t.account = '" + account + "'");

		return query.getResultList();
	}
	
	
}
