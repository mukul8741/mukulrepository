package org.axelor.guice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;

@Singleton
public class ServletTest extends HttpServlet{
	
//	@Inject
//	public Loan loan;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Injector inject = Guice.createInjector(new ModuleBinding());
		
		LoanImpl loan = inject.getInstance(LoanImpl.class);
		
		int amt = loan.amount(24000);
		
		resp.getWriter().println("Total amt = " + amt);
		
		resp.sendRedirect("index2.html");
       	}
	
    
}
