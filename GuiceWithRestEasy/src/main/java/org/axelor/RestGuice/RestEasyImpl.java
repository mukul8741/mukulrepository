package org.axelor.RestGuice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

@Path("")
public class RestEasyImpl {
	
//	public RestEasyImpl() {
//	}
	
	@Inject
	public HelloInterface hello;
	
//	@Inject
//	public RestEasyImpl(HelloInterface hello) {
//		
//		System.out.println("inside Inject");
//		this.hello = hello;
//		
//	}
	
	@GET
	@Path("{name}")
	public String hello(@PathParam("name") String name) {
		
		Injector injector = Guice.createInjector(new HelloModule());
		
		RestEasyImpl rs = injector.getInstance(RestEasyImpl.class);
	
		System.out.println("inside hello");
		return rs.hello.sayHello(name);
		
	}

}
