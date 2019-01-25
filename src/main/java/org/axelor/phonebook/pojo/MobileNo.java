package org.axelor.phonebook.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "mobileno")
public class MobileNo {
	
	@Id
	@GeneratedValue
	int id;
	
	int number;
	
		public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	

}
