package org.axelor.guice.Main;

import org.axelor.guice.Module.BindModule;
import org.axelor.guice.Service.GuiceService;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainClass {
	
	public static void main(String[] args) {
		
		Injector inject = Guice.createInjector(new BindModule());
		
		GuiceService serv = inject.getInstance(GuiceService.class);
		
		serv.show("Mukul");
		
		System.out.println("\n\n");
		
		serv.fancyPrinter.show("Fancy");
		
		System.out.println("\n\n");
		
		serv.simplePrinter.show("Simple");
		
		/**
		 * Instance Binding Use
		 */
		
		System.out.println("\n\n");
		serv.show2();
		
	}

}
