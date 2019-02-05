package org.axelor.RestGuice;

public class HelloImpl implements HelloInterface{

	@Override
	public String sayHello(String name) {
		
		return ("Hello " + name);
		
	}

}
