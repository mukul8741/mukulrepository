package org.axelor.Implementation;

import org.axelor.guice.Interface.PrinterInterface;

public class FancyPrinter implements PrinterInterface{

	@Override
	public void show(String data) {
		System.out.println("Fancy Data : ***** " + data.toUpperCase() + "*****");
	}
	
}
