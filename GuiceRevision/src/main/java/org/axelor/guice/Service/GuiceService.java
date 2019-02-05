package org.axelor.guice.Service;

import org.axelor.guice.Interface.PrinterInterface;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class GuiceService {
	
	@Inject
	@Named("Fancy")
	public PrinterInterface fancyPrinter;
	
	@Inject
	@Named("Simple")
	public PrinterInterface simplePrinter;
	
	public void show(String data) {
		fancyPrinter.show(data);
		simplePrinter.show(data);
	}
	
	@Inject
	@Named("Hello")
	String s1;
	
	@Inject
	@Named("Marks")
	String s2;
	
	@Inject
	@Named("Marks")
	int mark;
	
	public void show2() {
		System.out.println(s1 + s2 + mark);
	}

}
