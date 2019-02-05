package org.axelor.rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
public class Student {
	
	
	String id;
	
	int marks;
	
	int clas;
	
	
	String name;

	
	public String getId() {
		return id;
	}

	@XmlID
	public void setId(String id) {
		this.id = id;
	}

	public int getMarks() {
		return marks;
	}

	@XmlElement
	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getClas() {
		return clas;
	}

	@XmlElement
	public void setClas(int clas) {
		this.clas = clas;
	}
	
	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
