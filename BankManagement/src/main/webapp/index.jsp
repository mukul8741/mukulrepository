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

<form method = "post" >
 <center>
   <h1>Welcome To Axelor Bank</h1><br><br>
   
   <table>
     <tr>
       <td>User ID:</td>
       <td><input type = "text" name = "user"></td>
     </tr>
     
     <tr>
       <td>Password:</td>
       <td><input type = "password" name = "pass"></td>
     </tr>
     
     
     <tr>
       <td></td>
       <td>
          <input class="button button2" type = "submit" value = "Login" formaction = "http://localhost:8080/BankManagement/app/login">
          <input class="button button2" type = "submit" value = "Register" formaction = "http://localhost:8080/BankManagement/register.jsp">
       </td>  
     </tr>
     
   </table>
 </center>
</form>

</body>
</html>