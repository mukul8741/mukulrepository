package com.axelor.workingOne;

import com.google.inject.Inject;

public class CarService {
	
	Car car;
	
	@Inject
	public CarService(Car car) {
		this.car = car;
	}
	
	void colour() {
		System.out.println(car.getColour());
		
	}
	
	void type() {
		System.out.println(car.getType());
	}

}
