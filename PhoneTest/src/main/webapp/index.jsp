<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
</body>


<%
   int a = 12;
   int b = 34;
%>

<script>
function fun(id) {
 
        window.location.replace("index.jsp?name=" + id + "&sub=math");
        
        <%
          if(request.getParameter("name") != null) {
              session.setAttribute("id", request.getParameter("name"));
              session.setAttribute("sub", request.getParameter("sub"));              
              RequestDispatcher rd = request.getRequestDispatcher("app/hello");
              rd.forward(request, response);
          }
       %>
        
    }
</script>


  <input type = "submit" id = <%= a %> value = "12" onclick="fun('<%= a %>')"><br>
<form>
  <input type = "submit" id = <%= b %> value = "34" onclick="fun('<%= b %>')"><br>

</form>

</body>
</html>