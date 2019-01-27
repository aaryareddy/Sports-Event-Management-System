<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta charset="utf-8">
    <meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <%   
  
    if(session.getAttribute("user") == null || session.getAttribute("user") =="root"){
	response.sendRedirect("login.jsp");
}
    %>
    <!-- bootstrap general -->

	<!-- <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" /> -->
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>

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
      	<a class = "navbar-brand" href="#">${message}</a>
        
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="<c:url value="LoginController">
              <c:param name="mode" value="fetch"/>
        				</c:url>">Home</a>
            </li>
 
            <li class="nav-item">
              	<a class="nav-link" href="logout.jsp">logout</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    
    </br>
        <!-- Page Content -->
        <div class="scrollable">
    <div class="container">

      <div class="row">

        <div class="col-lg-3">

				<form name="searchForm" action="SearchController" method="post" onSubmit="">
				<div class="list-group">
					<a class="list-group-item"><h4>Type</h4>
						<div class="form-check">
							<input type="checkbox" class="form-check-input" id="single" name = "type" value = "single" onchange = "onChecked()">
							<label class="form-check-label" for="checkbox100">Singleplayer</label>
						</div>
						<div class="form-check">
							<input type="checkbox" class="form-check-input" id="multiplayer" name = "type" value= "multiplayer" onchange = "onChecked()">
							<label class="form-check-label" for="checkbox100">Multiplayer</label>
						</div> </a> 
						<!--
						<div class="form-check">
							<input type="checkbox" class="form-check-input" id="fun" name = "type" value= "fun" onchange = "onChecked()">
							<label class="form-check-label" for="checkbox100">Fun</label>
						</div>
						<div class="form-check">
							<input type="checkbox" class="form-check-input" id="sports" name = "type" value = "Sports" onchange = "onChecked()">
							<label class="form-check-label" for="checkbox100">Sports</label>
						</div> </a> 
						 <a class="list-group-item"><h4>Date</h4>
						<div class="form-check">
							<input type="checkbox" class="form-check-input" id="sortdate" name= "date" value = "date" onchange = "onChecked()">
							<label class="form-check-label" for="checkbox100">Sort by Date</label>
						</div>
						
						 </a> 
						 <a class="list-group-item"><h4>Price</h4>
						<div class="form-check">
							<input type="radio" class="form-check-input" id="free" name= "price" value = "0.0" onchange = "onChecked()">
							<label class="form-check-label" for="checkbox100">Free</label>
						</div>
						<div class="form-check">
							<input type="radio" class="form-check-input" id="five" name= "price" value = "5.0" onchange = "onChecked()">
							<label class="form-check-label" for="checkbox100">Less than 5.0</label>
						</div>
						<div class="form-check">
							<input type="radio" class="form-check-input" id="ten" name= "price" value = "10.0" onchange = "onChecked()">
							<label class="form-check-label" for="checkbox100">Less than 10.0</label> </div>
							</a> -->
						<input type="submit" value = "Search" name = "submit"> 
				</div>
				</form>
				<!-- /.col-lg-2 -->
		</div>
		
		<p id = results></p>
       <div class="col-lg-9">
        <div class="row">
        <c:forEach items="${events}" var="event" varStatus = "loop">
            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
             
                <div class="card-body">
                  <h4 class="card-title">
                    <!-- <a href="#"><c:out value="${event.topic}" /></a> -->
                     <a id = "event${loop.index+1}" href="<c:url value="DetailsController">
            			<c:param name="topic" value="${event.topic}"/>
        				</c:url>"><c:out value="${event.topic}" /></a>
                    <h6 id="event-type"><c:out value="${event.eventType}" /></h6>
                  </h4>
                  <h5><c:out value="${event.price}" /></h5>
                  <p class="card-text"><c:out value="${event.eventDate}" /></p>
                </div>
                <div class="card-footer">
                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                </div>
              </div>
            </div>
           </c:forEach>


	
	
	          </div>
          <!-- /.row -->

       </div>
        <!-- /.col-lg-9 -->

	</div>
     <!--/.row -->

    </div>
    <!-- /.container -->
    
	<!-- Footer -->
    <footer class="py-2 bg-dark fixed-bottom">
      <div class="container">
        <p class="m-0 text-center text-white"></p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="bootstrap/js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.bundle.min.js"></script>  

</div>
</body>
</html>