package multipleTransaction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "BookTable")
public class Book {
	@Id
	int id;
	
	String name;
	int pages;
	
	public Book(int id,String name,int pages) {
		 this.id = id;
		 this.name = name;
		 this.pages = pages;
	}

}
