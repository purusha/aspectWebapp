<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="add">
		<input type="text" name="number" />
		<input type="submit" value="add" />
	</form>
	
	<br /><br /><br />
	<hr />
	
	<h1>Numbers available:</h1>
	
	<ul>
		<c:forEach var="n" items="${requestScope.list}">
		 	<li>${n}</li>
		</c:forEach>
	</ul>
</body>
</html>