package axelor;

import org.aopalliance.intercept.MethodInterceptor;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistModule;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

public class MainClass {
	public static void main(String[] args) {
		
		Injector inject = Guice.createInjector(new JpaPersistModule("testDB"));
		
		PersistService ps = inject.getInstance(PersistService.class);
		ps.start();
		
		GuiceService gs = inject.getInstance(GuiceService.class);
		
		MobileNo mob = new MobileNo();
		mob.setMobileNo(1234567);
		
		User user = new User();
		user.setEmail("mukul@gmail.com");
		user.setMobileno(mob);
		
		
		
	}

}
