

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "studentRGH")
public class Student {
	
	@Id
	@GeneratedValue
	int id;
	
	String name;
	int clas;
	int age;
	
	@OneToMany(cascade = CascadeType.PERSIST)
//	@JoinTable( name = "stud_join_game",
//	            joinColumns= @JoinColumn(name = "stdid", referencedColumnName = "id"),
//	            inverseJoinColumns = @JoinColumn(name = "Gameid", referencedColumnName = "id"))
//	
	List<Game> game;
	
	
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
	public int getClas() {
		return clas;
	}
	public void setClas(int clas) {
		this.clas = clas;
	}
	public List<Game> getGame() {
		return game;
	}
	public void setGame(List<Game> game) {
		this.game = game;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
