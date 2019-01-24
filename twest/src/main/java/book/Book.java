package book;

import javax.persistence.*;

import org.hibernate.annotations.Target;

@Entity(name = "Book")
@Table(name = "Books")

@AttributeOverrides({
	@AttributeOverride(
			name = "location1.city",
			column = @Column(name = "Location1_city")),
	@AttributeOverride(
			name = "location1.country",
			column = @Column(name = "Location1_country")),
	@AttributeOverride(
			name = "location2.city",
			column = @Column(name = "Location2_city")),
	@AttributeOverride(
			name = "location2.country",
			column = @Column(name = "Location2_country"))
})


public class Book {
	@Id
	private int Id;
	
	public String name;
	private String price;
	
	@Target(Location.class)
	private Interfc location1;
	
	@Target(Location.class)
	private Interfc location2;
	
    public Book(int id, String name, String price, Location location1,Location location2) {
    	Id = id;
    	
    	this.name = name;
    	this.price = price;
    	this.location1 = location1;
    	this.location2 = location2;
    	
    }
    
    public Book() {
    	
    }

}
