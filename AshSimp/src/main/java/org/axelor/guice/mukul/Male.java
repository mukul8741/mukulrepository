package org.axelor.guice.mukul;

public class Male implements Details{

	@Override
	public void name() {
		
		System.out.println("My Name is Mukul");
		
	}

	@Override
	public void age() {
		
		System.out.println("My age is 22");
		
	}

	@Override
	public void gender() {
		
		System.out.println("Gender : Male");
				
	}

}
