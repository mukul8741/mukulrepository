import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Employee") 
@Table(name = "emp1000")
public class Employee { 

@Id
private int id;  
private Name name;
  
public Name getName() {
	return name;
}
public void setName(Name name) {
	this.name = name;
}
public int getId() {  
    return id;  
}  
public void setId(int id) {  
    this.id = id;  
}  

}  