package providerBinding;

import com.google.inject.ImplementedBy;

@ImplementedBy(AllMeals.class)
public interface Food {
	void show();

}
