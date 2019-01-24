package org.axelor.guice;

public class HouseLoan implements Loan{

	int rate = 10;
	
	@Override
	public int amount(int loanAmt) {
		
		return (loanAmt + (loanAmt/10));
		
	}

}
