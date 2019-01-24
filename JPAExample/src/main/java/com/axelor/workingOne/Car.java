package com.axelor.workingOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {

	@Id
	@GeneratedValue
	int id;
	
	String name;
	String colour;
	int price;
	
	Car(){
		
	}
	
	public Car(int id,String name,String colour,int price) {
		
		this.id = id;
		
		this.name = name;
		this.colour = colour;
		
        this.price = price;
		
	}
	
	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getColour() {
		return colour;
	}

	public String getType() {
		
		return "Sports Car";
	}
	
	

}