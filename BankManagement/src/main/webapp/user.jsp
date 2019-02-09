<%@page import="org.axelor.pojo.Account"%>
<%@page import="org.axelor.guice.services.GuiceJpaService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.axelor.pojo.Transaction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<style>
 #t1 {
        border : 1px solid black;
        border-collapse : collapse;
     }
</style>

<script>
  function fun(pointer) {
	  
	  window.location.replace("user.jsp?point=" + pointer);
	  
	  <%
	     if(request.getParameter("point") != null) {
	    	 session.setAttribute("pointer",request.getParameter("point"));
	    	 RequestDispatcher rd = request.getRequestDispatcher("withdraw.jsp");
	    	 rd.forward(request,response);
	     }
	  %>
  }
  
function fun1(pointer) {
	  
	  window.location.replace("user.jsp?logout=" + pointer);
	  
	  <%
	     if(request.getParameter("logout") != null) {
	    	 System.out.println("session invalidation");
	         session.invalidate();
	         RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	    	 rd.forward(request,response);
	     }
	  %>
  }
  
</script>
<body>
 <h2>User ID :</h2> <%= session.getAttribute("userId") %><br>
 <h2>Account :</h2> <%= session.getAttribute("account") %> <br><br>
 
 <div style="float:right">
   <input type = "submit" value = "LogOut" onclick = "fun1('1')">
 </div>
 
 <center>
  <table>
    <tr>
      <td>
          <input type = "submit" value = "Withdraw" onclick = "fun('2')" >
          <input type = "submit" value = "Transfer fund" onclick = "fun('3')" >
          <input type = "submit" value = "LogOut" onclick = "fun1('1')" name = "logout">
      </td>
    </tr>
    
    <tr>
       <td></td>
    </tr>
    
    <tr>
      <td></td>
    </tr>
    
    <tr>
      <td>
        <table id = "t1">
          <tr>
            <th id = "t1">Transaction Id</th>
            <th id = "t1">Date</th>
            <th id = "t1">Amount</th>
            <th id = "t1">Type</th>
          </tr>
          
          
            <%
               GuiceJpaService service = (GuiceJpaService) session.getAttribute("servic");
            
            
  	           Account account = new Account();
		       account = (Account) service.find(account,(String) session.getAttribute("account"));
		                    
               List<Transaction> trans = new ArrayList<Transaction>();
               trans = service.findTransaction((String) session.getAttribute("account"));
               
               for(Transaction tranes:trans) {
            	   service.refresh(tranes);
            %>
              <tr>
               <td id = "t1"><%= tranes.getId() %> </td>
               <td id = "t1"><%= tranes.getDate() %> </td>
               <td id = "t1"><%= tranes.getAmount() %> </td>
               <td id = "t1"><%= tranes.getType() %></td>
              </tr>
               
            <%
               }
            %>
        </table>
      </td>
    </tr> 
    
    <tr>
       <td></td>
    </tr>
    
    <tr>
      <td></td>
    </tr>
        
    <tr>
        <td><h3>Available balance</h3></td>
        <td>
             <%= account.getBalance() %> 
        </td>
    </tr>
  </table>
 </center>

</body>
</html>