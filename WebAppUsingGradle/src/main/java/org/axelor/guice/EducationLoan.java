package org.axelor.guice;

public class EducationLoan implements Loan{
	
    
	
	@Override
	public int amount(int loanAmt) {
		
		return (loanAmt + (loanAmt/20));
		
	}

}
