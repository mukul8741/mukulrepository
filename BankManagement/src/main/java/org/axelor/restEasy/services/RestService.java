package org.axelor.restEasy.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.axelor.guice.services.GuiceJpaService;
import org.axelor.pojo.Account;
import org.axelor.pojo.Transaction;
import org.axelor.pojo.Users;
import com.google.inject.Inject;

@Path("")
public class RestService {
	

	@Inject
	GuiceJpaService service;
	
	@GET
	@Path("register")
	@Consumes("application/x-www-form-urlencoded")
	public Response register(@QueryParam("users") String usersId, @QueryParam("pass") String pass,
			@QueryParam("account") String accountNo, @QueryParam("mobile") String mobile, @QueryParam("email") String email) {
	
		Users users = new Users();
		
		users.setEmail(email);
		users.setMobile(mobile);
		users.setPassword(pass);
		users.setUserID(usersId);
		
		service.save(users);
		
		Account account = new Account();
		
		account.setAccountNumber(accountNo);
		account.setBalance(0.0);
		account.setUser(users);
		
		service.save(account);
		
		URI uri = null;
		try {
			uri = new URI("http://localhost:8080/BankManagement/registerSuccess.jsp");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.temporaryRedirect(uri).build();
	}
	
	@POST
	@Path("login")
	
	public Response login(@FormParam("user") String userId,@FormParam("pass") String pass, @Context HttpServletRequest request) {
			
		HttpSession session = request.getSession();
		URI location = null;
		        
		Users users = new Users();
		
		users = (Users) service.find(users,userId);
				
		if(users.getPassword().equals(pass)) {
			
			session.setAttribute("id", userId);
			
			session.setAttribute("servic", service);
			
			if(users.getRole() != null) {
			
				try {
					location = new URI("http://localhost:8080/BankManagement/admin.jsp");
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}

			} else {
				
				try {
					location = new URI("http://localhost:8080/BankManagement/userAccounts.jsp");
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
			
            return Response.temporaryRedirect(location).build();
             
		} else {
			
			try {
				location = new URI("http://localhost:8080/BankManagement/loginError.jsp");
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			return Response.temporaryRedirect(location).build();

		}
				
	}
	
	@Path("operations")
	@GET
	
	public Response operations(@Context HttpServletRequest request) throws URISyntaxException {
		
		HttpSession session = request.getSession();
		
		String pointer = (String) session.getAttribute("pointer");
		
		if(pointer.equals("2")) {
			
		     return Response.temporaryRedirect(new URI("http://localhost:8080/BankManagement/withdraw.jsp")).build();
		}
		return null;
			
	}
	
	@GET
	@Path("withdraw")
	
	public Response withdraw(@QueryParam("amount") Double amount, @Context HttpServletRequest request) throws URISyntaxException {
		
		 HttpSession session = request.getSession();
		 Account account = new Account();
	     account = (Account) service.find(account,(String) session.getAttribute("account"));
	     	     
	     if(account.getBalance() < amount) {
	    	 
	    	return Response.temporaryRedirect(new URI("http://localhost:8080/BankManagement/insufficient.jsp")).build();
	     
	     } else {

	    	 Double remaning;
	    	 remaning = account.getBalance() - amount;
	    	 
	    	 account.setBalance(remaning);
	    	 
	    	 service.save(account);
	    	 
	    	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    	 String now = LocalDateTime.now().format(dtf); 
	    	  
	    	 Transaction txn = new Transaction();
	    	 txn.setAmount(-1 * amount);
	    	 txn.setDate(now);
	    	 txn.setType("Withdraw");
	    	 txn.setAccount(account);
	    	 
	    	 service.save(txn);
	    	 	    	 
		     return Response.temporaryRedirect(new URI("http://localhost:8080/BankManagement/withdrawSuccess.jsp")).build();

	     }
		
	}
	
	@GET
	@Path("transfer")
	
	public Response transfer(@QueryParam("amount") Double amount, @QueryParam("accountNo") String accountNo, @Context HttpServletRequest request) throws URISyntaxException {
		
		HttpSession session = request.getSession();
		
		Account receiver = new Account();
		Account sender = new Account();
		
		receiver = (Account) service.find(receiver, accountNo);
		receiver.setBalance(receiver.getBalance() + amount);
		service.save(receiver);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   	    String now = LocalDateTime.now().format(dtf);
   	 
		Transaction txn1 = new Transaction();
		txn1.setAccount(receiver);
		txn1.setAmount(amount);
		txn1.setDate(now);
		txn1.setType("Recieved from "+ session.getAttribute("account"));
		
		service.save(txn1);
		
		sender = (Account) service.find(sender,(String) session.getAttribute("account"));
		sender.setBalance(sender.getBalance() - amount);
		
		service.save(sender);
		
		Transaction txn2 = new Transaction();
		txn2.setAccount(sender);
		txn2.setAmount(-1 * amount);
		txn2.setDate(now);
		txn2.setType("Fund sent to " + accountNo);
		
		service.save(txn2);
		
		return Response.temporaryRedirect(new URI("http://localhost:8080/BankManagement/withdrawSuccess.jsp")).build();
		
		
		
	}

}
