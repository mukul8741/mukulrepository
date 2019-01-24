package hqlPractise;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClassTeacher {
	
	int id;
	
	Name name;
	@Id
	int clas;
	String contactNo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public int getClas() {
		return clas;
	}
	public void setClas(int clas) {
		this.clas = clas;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	

}
