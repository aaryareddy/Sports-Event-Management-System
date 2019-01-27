<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- bootstrap general -->

	<!-- <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" /> -->
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add event result</title>
<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="bootstrap/css/shop-homepage.css" rel="stylesheet">

</head>
<body>
   

<%
//allow access only if session exists
String user = null;
		if(session.getAttribute("user") == null || session.getAttribute("user") !="root"){
			response.sendRedirect("login.jsp");
		}
else user = (String) session.getAttribute("user");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
	if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}


%>
<c:if test="${status == '1'}">
	<h4 id="result">Sports Event has been added.</h4>
	<a href="add_event.jsp">Add another Sports Event</a><br/>
	<a href="admin.jsp">Home page</a>
</c:if>

<c:if test="${status == '0'}">
	<h4 id="result">Empty fields are not allowed. Try again.</h4>
	<a href="add_event.jsp">Add Sports Event</a><br/>
	<a href="admin.jsp">Home page</a>
</c:if>

<c:if test="${status == '2'}">
	<h4 id="result">Invalid Event type. Try again.</h4>
	<a href="add_event.jsp">Add Sports Event</a><br/>
	<a href="admin.jsp">Home page</a>
</c:if>

<c:if test="${status == '3'}">
	<h4 id="result">Invalid Date. Try again.</h4>
	<a href="add_event.jsp">Add Sports Event</a><br/>
	<a href="admin.jsp">Home page</a>
</c:if>

<c:if test="${status == '4'}">
	<h4 id="result">Invalid Price. Try again.</h4>
	<a href="add_event.jsp">Add Sports Event</a><br/>
	<a href="admin.jsp">Home page</a>
</c:if>

<c:if test="${status == '5'}">
	<h4 id="result">Invalid Time. Try again.</h4>
	<a href="add_event.jsp">Add Sports Event</a><br/>
	<a href="admin.jsp">Home page</a>
</c:if>

    <!-- Bootstrap core JavaScript -->
    <script src="bootstrap/js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.bundle.min.js"></script> 

</body>
</html>