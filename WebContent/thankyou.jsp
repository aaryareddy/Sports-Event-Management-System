<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Thank You Page</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="bootstrap/css/shop-homepage.css" rel="stylesheet">

<script>
var type = document.getElementByName('type');
alert(type.value);
</script>
</head>


<body>
	<!-- Navigation -->

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">${message}</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="logout.jsp">logout</a>
				</li>
			</ul>
		</div>
	</div>
	</nav>
	<%
out.println("<div class=\"jumbotron text-xs-center\">");
out.println("  <h1 class=\"display-3\">Thank You!</h1>");
out.println("  <p class=\"lead\"><strong>Please check your reservations</strong> for further details.</p>");
//out.println("  <hr>");
out.println("</div>");
%>

  <a href="welcome.jsp" id = "welcome">Home page</a>
	<p>${errormessage}</p>





	<!-- Footer -->
	<footer class="py-2 bg-dark fixed-bottom">
	<div class="container">
		<p class="m-0 text-center text-white">/p>
	</div>
	<!-- /.container --> </footer>

	<!-- Bootstrap core JavaScript -->
	<script src="bootstrap/js/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>