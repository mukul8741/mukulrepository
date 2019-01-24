package associationAndMapping;

import javax.persistence.*;

@Entity
public class Book {
	@Id
	int bookid;
	
	String bookname;

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	
	
}
