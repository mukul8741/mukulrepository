package com.axelor.workingOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class StoreData {
	
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testDB");
		
		EntityManager entitymanager = emf.createEntityManager();
		entitymanager.getTransaction().begin();
		
		Injector injector = Guice.createInjector(new BindingModule());
		
		CarService carService = injector.getInstance(CarService.class);
		
		carService.car.set
		
	}
	
}
