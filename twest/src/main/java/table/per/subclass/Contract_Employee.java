package table.per.subclass;

import javax.persistence.*;

@Entity

@DiscriminatorValue("Contract_Emp")

//@PrimaryKeyJoinColumn(name = "EID")
//@Table(name = "emp2")

public class Contract_Employee extends Employee{
	int Total_hours;
	
	int Rate_per_hour;
	
	public Contract_Employee(String name1,int rate,int hour) {
		Total_hours = hour;
		Rate_per_hour = rate;
		name = name1;
	}

}
