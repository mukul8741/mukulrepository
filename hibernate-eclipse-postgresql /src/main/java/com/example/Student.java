package com.example;

import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.Entity;

@Entity
public class Student {
	@Id
	int rollno;
	
	@Column(name = "S_Name")
	String name;
	
	@Column(name = "Total")
	int Marks;
	
	@Column(name = "Percentage")
	int percent;

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return Marks;
	}

	public void setMarks(int marks) {
		Marks = marks;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	
	

}
