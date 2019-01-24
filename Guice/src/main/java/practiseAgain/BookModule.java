package practiseAgain;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import providerBinding.AllMeals;
import providerBinding.Food;

public class BookModule extends AbstractModule{
	
	@Override
	public void configure() {
		bind(BookInterface.class).to(BookClass.class);
		
		bind(Food.class);
		
//		bind(AttendenceInterface.class).to(Attendence.class);
//		
//		bind(Integer.class).toInstance(20);
		
		/**
		 * 
		 * Constructer Binding
		 * 
		 * using toConstructor() method
		 */
		
//		try {
//			bind(Food.class).toConstructor(AllMeals.class.getConstructor(String.class));
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
	
	@Provides
	AttendenceInterface AttendProvides(String name,String clas) {
		Attendence attend = new Attendence();
		attend.name = "Mukul";
		attend.clas = "12th";
		
		return attend;
		
	}

}
