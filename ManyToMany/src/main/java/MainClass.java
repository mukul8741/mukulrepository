import java.util.ArrayList;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

public class MainClass {
	
	public static void main(String[] args) {
		

		Injector inject = Guice.createInjector(new JpaPersistModule("testDB"));
		
		PersistService ps = inject.getInstance(PersistService.class);
		ps.start();
		
		ServiceImpl sl = inject.getInstance(ServiceImpl.class);
		
		
		Game game1 = new Game();
		game1.setCoach("p.shekhawat");
		game1.setName("Football");
		
		Game game2 = new Game();
		game2.setCoach("R.sharma");
		game2.setName("Cricket");
		
//		sl.saveStudent(game1);
//		sl.saveStudent(game2);
		
		List<Game> list = new ArrayList<Game>();
		list.add(game1);
		list.add(game2);
		
		Student stud = new Student();
		stud.setAge(14);
		stud.setClas(12);
		stud.setName("Manish");
		stud.setGame(list);
		
		sl.saveStudent(stud);
		System.out.println("Done");
		
		Student stud2 = sl.em.find(Student.class, 1);
		
		sl.em.getTransaction().begin();
		
		Game game3 = new Game();
		game3.setCoach("P Ram");
		game3.setName("archery");
		
		
		
//		System.out.println(list1);
		
		
//		sl.em.persist(stud2);
		List<Game> list1 = stud2.getGame();
		list1.add(game3);
		stud2.setGame(list1);
		
		sl.em.getTransaction().commit();
		
		
		System.out.println("Done Again");
	}

}
