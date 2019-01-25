package org.axelor.phonebook.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Connecteduser")
public class ConnectUser {
	
	@Id
	@GeneratedValue
	int id;
	
	int userID;
	int connectUserID;
	
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
	public int getConnectUserID() {
		return connectUserID;
	}
	public void setConnectUserID(int connectUserID) {
		this.connectUserID = connectUserID;
	}
	
	

}
