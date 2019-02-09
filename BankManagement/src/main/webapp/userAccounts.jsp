<%@page import="org.axelor.guice.services.GuiceJpaService"%>
<%@page import="com.google.inject.Inject"%>
<%@page import="java.util.List"%>
<%@page import="org.axelor.pojo.Account"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<style>

#th1 {
  border: 1px solid black;
  border-collapse: collapse;
}

</style>

<script>
  function fun(account) {
	  window.location.replace("userAccounts.jsp?account=" + account)
	  
	  <%
	     if(request.getParameter("account") != null) {
	    	 session.setAttribute("account", request.getParameter("account"));
	    	 session.setAttribute("userId",session.getAttribute("id"));
	    	 RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
	    	 rd.forward(request,response);
	     }
	  %>
  }

</script>
  <table>
    <tr>
      <td> <h3>Your Available Accounts </h3> </td>
    </tr>
    
    <tr>
      <%
        GuiceJpaService service = (GuiceJpaService) session.getAttribute("servic");
        String id = (String) session.getAttribute("id");
        
        List<Account> accounts = new ArrayList<Account>();
        
        accounts = service.findAccounts(id);  
        
     %>
       <table id = "th1">  
        <th id = "th1"> Account No</th>  
        <th id = "th1"></th> 
     <%    
        for(Account account:accounts) {
      
     %>
        <tr>
           <td id = "th1"> <%= account.getAccountNumber() %> </td>
           <td id = "th1"> <input type = "submit" value = "Details" onclick = "fun('<%= account.getAccountNumber() %> ')" > </td>
        </tr>
        
      <% 
        }
      %>
       </table>
    </tr>
  </table>
</body>
</html>