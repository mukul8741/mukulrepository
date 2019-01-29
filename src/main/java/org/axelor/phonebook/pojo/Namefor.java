package org.axelor.phonebook.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Namefor {
	
	@Id
	@GeneratedValue
	int id;
	
	String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<MobileNo> number;

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

	public List<MobileNo> getNumber() {
		return number;
	}

	public void setNumber(List<MobileNo> number) {
		this.number = number;
	}

	
	
	

}
