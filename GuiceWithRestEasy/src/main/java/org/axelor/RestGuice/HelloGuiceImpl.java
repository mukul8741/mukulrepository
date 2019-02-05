package org.axelor.RestGuice;

import com.google.inject.Inject;

public class HelloGuiceImpl {
	
	    //@Inject
		public HelloInterface hello;
		
		//@Inject
		public HelloGuiceImpl(HelloInterface hello) {
			
			System.out.println("inside Inject");
			this.hello = hello;
			
		}
		
		public void hello(String name) {
			hello.sayHello(name);
		}


}
