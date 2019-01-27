<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>logout page</title>
<% 

		
	//	Cookie ck = new Cookie("logout","yes");
	//	response.addCookie(ck);
		session.invalidate();
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "0");
		response.setHeader("Vary", "*");
		
%>
</head>
<body>

    <script type="text/javascript" src="script.js"></script>
    <script type="text/javascript">
       clear();
    </script>
<%
	
	

	
	response.sendRedirect("login.jsp");
%>

</body>
</html>