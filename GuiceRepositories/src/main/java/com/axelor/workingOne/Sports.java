package com.axelor.workingOne;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cars")
public class Sports implements Car {

	@Id
	@GeneratedValue
	int id;
	
	String name;
	String colour;
	int price;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String getColour() {
		return colour;
	}

	@Override
	public String getType() {
		
		return "Sports Car";
	}
	
	

}
