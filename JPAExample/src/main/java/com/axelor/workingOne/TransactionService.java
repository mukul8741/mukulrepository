package com.axelor.workingOne;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class TransactionService {

	@Inject
	public EntityManager em;
    
    @Transactional                            /** if we don't write @Transactional then the vale of car obj. will not save in table*/
    public void save(Car car) {
        em.persist(car);
    }

}
