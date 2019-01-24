package simpleDependencyInjection;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainClass {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new ModuleClass());
		
		Student stud = injector.getInstance(Student.class);
		
		
       stud.get("English");
		
		stud.get("English");
		
		
		stud.get("Maths");
		
		
		stud.get("Hindi");
		
		
		stud.get("Physics");
		
		
		stud.get("Chemistry");
		
	}

}
