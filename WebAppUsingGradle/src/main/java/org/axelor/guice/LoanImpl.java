package org.axelor.guice;

import com.google.inject.Inject;

public class LoanImpl {
	
	public Loan loan;
	
	@Inject
	public LoanImpl(Loan loan) {
		this.loan = loan;
	}
	
	public int amount(int amt) {
		return loan.amount(amt);
	}

}
