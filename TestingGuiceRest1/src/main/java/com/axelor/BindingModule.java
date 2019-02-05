package com.axelor;

import org.axelor.pojo.Car;
import org.axelor.pojo.Vehicle;
import org.hibernate.Hibernate;

//import com.axelor.binding.HiberanteInterface;
//import com.axelor.binding.HibernateImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Module;

public class BindingModule implements Module{

	@Override
	public void configure(Binder binder) {
		binder.bind(RestServ.class);
		binder.bind(Vehicle.class).to(Car.class);		
	}

}
