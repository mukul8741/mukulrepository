package practiseAgain;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainClass {
	public static void main(String[] args) {
        Injector inject = Guice.createInjector(new BookModule());
        
        Students stud = inject.getInstance(Students.class);
        
        stud.show1();
        stud.show2();
	}

}
