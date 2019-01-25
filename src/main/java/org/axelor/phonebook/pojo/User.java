package org.axelor.phonebook.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "userphonebook")
public class User {
	
	@Id
	@GeneratedValue
	int id;
	
	String name;
	String email;
	String paswd;
		
	@OneToMany
	List<MobileNo> mobile;
	
	public List<MobileNo> getMobile() {
		return mobile;
	}
	public void setMobile(List<MobileNo> mobile) {
		this.mobile = mobile;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPaswd() {
		return paswd;
	}
	public void setPaswd(String paswd) {
		this.paswd = paswd;
	}
	
	
	

}
