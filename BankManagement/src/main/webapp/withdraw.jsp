<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<style>

.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 12px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.button2 {border-radius: 4px;}

</style> 

<script>

  function fun() {
	  
	  <%
	    if(request.getParameter("donebtn") != null) {
	    	String temp = (String) session.getAttribute("pointer");
	    	
	     if(request.getParameter("accountNo") != null)
	    	 request.getRequestDispatcher("app/transfer").forward(request,response);
	     
	     else
	    	 request.getRequestDispatcher("app/withdraw").forward(request,response);
	  
	    }
	  %>
  }
</script>

<body>
<form>
   <center>
    <h1>Enter Amount</h1> <br> 
    
    <input type = "number" name = "amount">
    <br>
    
    <div id = "para">
    <h1>Enter AccountNo</h1> <br>
      <input type = "text" name = "accountNo">  
      <br>
    </div>
    
    <input type = "submit" value = "Done" class = "button button2" onclick = "fun()" name = "donebtn">
    
    <p >
   </center>
   
</form>  
</body>
</html>

