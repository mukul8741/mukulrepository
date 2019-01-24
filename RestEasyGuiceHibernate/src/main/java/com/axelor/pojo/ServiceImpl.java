package com.axelor.pojo;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

@Singleton
public class ServiceImpl {
	
	@Inject
	public EntityManager em;
	
	@Transactional
	public void saveStudent(Student stud) {
		em.persist(stud);
	}
	
	@Transactional
	public void findStudent(int id) {
		em.find(Student.class, id);
	}

}
