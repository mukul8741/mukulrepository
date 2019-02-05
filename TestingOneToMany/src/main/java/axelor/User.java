package axelor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "userphonebook")
public class User {
	
	@Id
	@GeneratedValue
	int id;
	
	String name;
	String email;
	String paswd;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "phonebook_join",
	            joinColumns = @JoinColumn(name = "User_id", referencedColumnName = "id"),
	            inverseJoinColumns = @JoinColumn(name = "Mob_id", referencedColumnName = "id"))

	MobileNo mobileno;
	
	public MobileNo getMobileno() {
		return mobileno;
	}
	public void setMobileno(MobileNo mobileno) {
		this.mobileno = mobileno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPaswd() {
		return paswd;
	}
	public void setPaswd(String paswd) {
		this.paswd = paswd;
	}
	
	
	

}
