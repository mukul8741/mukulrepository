package org.axelor.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

public class ContextListener1 extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		
		return Guice.createInjector(new ServletModule() {
			
			@Override
		    protected void configureServlets() {
//				filter("/*").through(GuiceFilter.class);
				serve("/123.html").with(ServletTest.class);    /*index.html redirected here */ 
				//bind(Loan.class).to(EducationLoan.class);
			}
		});
	}

}
