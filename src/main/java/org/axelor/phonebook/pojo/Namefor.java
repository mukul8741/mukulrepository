package org.axelor.phonebook.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Namefor {
	
	@Id
	@GeneratedValue
	int id;
	
	int userID;
	int connectUserId;
	
	String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getConnectUserId() {
		return connectUserId;
	}

	public void setConnectUserId(int connectUserId) {
		this.connectUserId = connectUserId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
