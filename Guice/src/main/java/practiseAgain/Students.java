package practiseAgain;

import com.google.inject.Inject;

public class Students {
	public final BookInterface book;
	public final AttendenceInterface attend;
	
	@Inject
	public Students(BookInterface book,AttendenceInterface attend) {
        this.book = book;
        this.attend = attend;
        
        
    }
	
	public void show1() {
		book.show();
		
	}
	
	public void show2() {
        attend.show();
	}

}
