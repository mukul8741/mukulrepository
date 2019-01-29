<%@page import="org.axelor.phonebook.pojo.MobileNo"%>
<%@page import="javax.persistence.Query"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.axelor.phonebook.pojo.Namefor"%>
<%@page import="java.util.List"%>
<%@page import="org.axelor.phonebook.guice.GuiceService"%>
<%@page import="com.google.inject.persist.PersistService"%>
<%@page import="com.google.inject.persist.jpa.JpaPersistModule"%>
<%@page import="com.google.inject.Guice"%>
<%@page import="com.google.inject.Injector"%>

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
  border: 1px solid black;
  border-collapse: collapse;
}

table {
  
  }
</style>

<body>
 <form method="post" action="app/phone/update">
  <center>
  <h1>Update Contacts</h1>
    <h3>Enter Id for Update:</h3>
    <input type = "number" name = "id"><br>
 
    <h3>Enter New Number</h3>
    <input type = "number" name = "numb"><br>
    
    <input type = "submit" value="Update" ><br><br>
  
    <table id = "t1">
      <tr>
        <th id = "t1">Id</th>
        <th id = "t1">Name</th>
        <th id = "t1">Number</th>
      </tr>
      
      <%
      
        Injector inject = Guice.createInjector(new JpaPersistModule("testDB"));
        PersistService ps = inject.getInstance(PersistService.class);
		ps.start();
		
	    GuiceService gs = inject.getInstance(GuiceService.class);
	  
	    List<Namefor> list1 = new ArrayList<Namefor>();
	   
	    Query query = gs.em.createQuery("select n from Namefor n");
	   
	    list1 = query.getResultList();
	   
	    for(Namefor name:list1) {
		   
	 %>
	   
	   <tr>
	    <td id = "t1"><%= name.getId() %></td>
	    <td id = "t1"><%= name.getName() %></td>
	    <td id = "t1">
	    
	     <table>
	    
	    <%
	       List<MobileNo> list2 = new ArrayList<MobileNo>();
	       list2 = name.getNumber();
	    
	       for(MobileNo mob:list2) {
	    %>
	       
	       
	         <tr><td><%=mob.getNumber() %></td></tr>
	         
	   <%   	   
	       }
	   %>
	    </table>
	   </td>
	  </tr>
	<%     
	   }
	 %>
    
    </table>
  
  </center>

</form>

</body>
</html>