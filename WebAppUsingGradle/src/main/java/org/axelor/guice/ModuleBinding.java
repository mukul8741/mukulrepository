package org.axelor.guice;

import com.google.inject.AbstractModule;

public class ModuleBinding extends AbstractModule{

	@Override
	protected void configure() {
		bind(Loan.class).to(EducationLoan.class);
		
	}

}
