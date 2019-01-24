package table.per.subclass;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@DiscriminatorColumn(name = "table_name", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Employee")

@Table(name = "emp1")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String name;
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Employee(String name) {
		this.name = name;
	}
	
	public Employee() {
		
	}
}
