package hqlPractise;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
public class Student {
	@Id
	int id;
	
	Name name;
//	Integer clas;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "class", referencedColumnName = "clas")
	
	ClassTeacher teacher;
	
	public int getId() {
		return id;
	}
	public ClassTeacher getTeacher() {
		return teacher;
	}
	public void setTeacher(ClassTeacher teacher) {
		this.teacher = teacher;
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
//	public Integer getClas() {
//		return clas;
//	}
//	public void setClas(Integer clas) {
//		this.clas = clas;
//	}
//	
//	

}
