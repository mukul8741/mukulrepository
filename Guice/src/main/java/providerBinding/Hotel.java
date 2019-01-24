package providerBinding;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class Hotel {
    public  Food food;
    
    @Inject
    Hotel(Food food) {
    	this.food = food;
    }
	
//	@Override
//	public Food get() {
//        AllMeals meal = new AllMeals();
//		return meal;
//	}
	
	void show() {
		food.show();
	}

}
