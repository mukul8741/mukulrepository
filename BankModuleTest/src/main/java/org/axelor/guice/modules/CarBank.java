package org.axelor.guice.modules;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarBank {
	
	@Id
	int id;
	
	String name;

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
	
	

}
