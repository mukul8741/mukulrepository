package providerBinding;

import com.google.inject.Guice;
import com.google.inject.Injector;

import practiseAgain.BookModule;

public class MainClass {
	public static void main(String[] args) {
		
		Injector injecter = Guice.createInjector(new BookModule());
		
		Hotel hotel = injecter.getInstance(Hotel.class);
		
		hotel.show();
	}

}
