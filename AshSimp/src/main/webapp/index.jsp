<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>PhoneBook</h1>
		<form method="post" action="<%= request.getContextPath() %>/add2">
			<table cellpadding="3pt">
				<tr>
					<td>User Name :</td>
					<td><input type="text" name="cname" size="30" /></td>
				</tr>
				<tr>
					<td>Contact Number:</td>
					<td><input type="text" name="cnumber" size="30" /></td>
				</tr>
			</table>
			<input type="submit" value="Register" />
		</form>
		<br> <br>
		<form method="get" name="form2">
			<table cellpadding="3pt" border="1">
				<tr>
					<td>User Name</td>
					<td>Contact No</td>
					<td colspan="2">Action</td>
				</tr>
				<c:forEach items="${contact}" var="contact">
					<tr>
						<td>${contact.cname}
						</td>
						<td>${contact.cnumber}
						</td>
						<td><a href="update.jsp?${contact.id}">update</a></td>
						<td><a href="<%= request.getContextPath() %>/delete/${contact.id}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</center>
</body>
</html>