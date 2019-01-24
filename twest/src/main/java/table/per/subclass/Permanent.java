package table.per.subclass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Permanent")

//@PrimaryKeyJoinColumn(name = "EID")
//@Table(name = "emp3")
public class Permanent extends Employee{
	int salary;
	
	int bonus;
	
	public Permanent(String name1,int salary, int bonus) {
		this.salary = salary;
		this.bonus = bonus;
		this.name = name1;
	}

}
