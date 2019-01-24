package providerBinding;

import com.google.inject.Inject;

public class AllMeals implements Food{
	String name;
	
	public AllMeals() {
//		this.name = name;
	}

	@Override
	public void show() {
		System.out.println("\nBreakFast : 30 \nLunch : 50 \nDinner : 60 \n");
		
	}
	

}
