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
<title>Edit Form</title>
<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="bootstrap/css/shop-homepage.css" rel="stylesheet">

</head>
<body>
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Reserve Tickets</a>
        
        
      </div>
    </nav>

<%
//allow access only if session exists
String user = null;
		if(session.getAttribute("user") == null || session.getAttribute("user") !="root"){
			response.sendRedirect("login.jsp");
		}
if(session.getAttribute("user") == null){
	response.sendRedirect("login.html");
}else user = (String) session.getAttribute("user");
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
<c:if test="${empty fn:trim(selectedEventId)}">
	<% response.sendRedirect("edit_event.jsp");%>
	
</c:if>
<center>
<h4>Hi <%=userName %>, Login successful. Your Session ID=<%=sessionID %></h4>
<br>
User=<%=user %>
<br>
<a href="logout.jsp">logout</a>

<form name="addform" action="AdminController" method="post" onsubmit="" >
	<br>
		
	Event ID: <input type="text" name="id" id="id" readonly value="${selectedEventId.eventId}"><br>
	Event topic: <input type="text" name="title" id="title" value="${selectedEventId.topic}"><br>
	Type: <input type="text" name="type" id="type" value="${selectedEventId.eventType}"><br>
	Date: <input type="date" pattern="yyyy/MM/dd" name="date" id="date" value="${selectedEventId.eventDate}"><br>
	Location: <input type="text" name="loc" id="loc" value="${selectedEventId.location}"><br>
	Price: <input type="text" name="price" id="price" value="${selectedEventId.price}"><br>
	EventTime: <input type="text" name="time" id="time" value="${selectedEventId.eventTime}"><br>
	Description: <input type="text" name="desc" id="desc" value="${selectedEventId.description}"><br>
	
	<input type="submit" name="submit" value="edit_form"><br>
	
	
</form>
</center>

	<!-- Footer -->
    <footer class="py-5 bg-dark fixed-bottom">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Group:5</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="bootstrap/js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.bundle.min.js"></script> 

</body>
</html>