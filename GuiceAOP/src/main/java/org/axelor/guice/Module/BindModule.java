package org.axelor.guice.Module;

import org.axelor.Implementation.FancyPrinter;
import org.axelor.Implementation.SimplePrinter;
import org.axelor.guice.Interface.PrinterInterface;
import org.axelor.guice.MethodInterceptor.Intercept;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matcher;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;

public class BindModule extends AbstractModule{
	
	@Override
	protected void configure() {
		bind(PrinterInterface.class).annotatedWith(Names.named("Fancy")).to(FancyPrinter.class);
		bind(PrinterInterface.class).annotatedWith(Names.named("Simple")).to(SimplePrinter.class);
		
		/**
		 * 
		 * Instance Binding
		 * 
		 */
		
		bind(String.class).annotatedWith(Names.named("Hello")).toInstance("Hello Mukul ");
		bind(String.class).annotatedWith(Names.named("Marks")).toInstance("You Got ");
		bind(Integer.class).annotatedWith(Names.named("Marks")).toInstance(99);
		
		/**
		 * AOP programming MethodInterceptor
		 */
		
		bindInterceptor(Matchers.any(), Matchers.annotatedWith(Names.named("Inter")),new Intercept());
	}

}
