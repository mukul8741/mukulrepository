package collectionPractise;

import java.util.List;

import javax.persistence.*;

@Entity
public class ListCollection {
	
	@Id
	int id;
	
	String name;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id")
//	@OrderColumn(name = "index")
	
	@ElementCollection
	List<String> thoughts;

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

	public List<String> getThoughts() {
		return thoughts;
	}

	public void setThoughts(List<String> thoughts) {
		this.thoughts = thoughts;
	}
	
	

}
