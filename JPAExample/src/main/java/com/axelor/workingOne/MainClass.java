package com.axelor.workingOne;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

public class MainClass {
	
	public static void main(String args[]) {
		
		Injector inject = Guice.createInjector(new JpaPersistModule("testDB"));
		
		PersistService ps = inject.getInstance(PersistService.class);
		ps.start();
		
		TransactionService ts = inject.getInstance(TransactionService.class);
		
		Car car = new Car();
		
		car.setColour("Red");
//		car.setId(1);                           /* this gives error for deteched entity because of @GeneratedValue on id in Car.class
		car.setName("Lamborgani");
		car.setPrice(10000000);
		
		ts.save(car);
		
		System.out.println("Check DataBase");
		
	}

}
