package associationAndMapping;

import javax.persistence.CascadeType;

import java.util.List;

import javax.persistence.*;

@Entity
public class Student {
	@Id
	int id;
	
	String name;
	String Classe;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Stud_Join",
	           joinColumns = @JoinColumn(name = "StuId",referencedColumnName = "id"),
	           inverseJoinColumns = @JoinColumn(name = "BookId",referencedColumnName = "bookid")
	)
	//@JoinColumn(name = "bookid")
	List<Book> bookname;
	
	public List<Book> getBookname() {
		return bookname;
	}
	public void setBookname(List<Book> bookname) {
		this.bookname = bookname;
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
	public String getClasse() {
		return Classe;
	}
	public void setClasse(String classe) {
		Classe = classe;
	}

}
