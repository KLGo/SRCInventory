<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="design.css">
<title>Inventory LOGIN</title>
</head>
<body class="index">
<center>
	<img src="images/solaire_logo.png" ></img><form action="loginprocess.html" method="post">
	
	<h2>TSSR Inventory - Login Page</h2>
	<%if(request.getAttribute("error")!=null){ %>
	<p>Error:<%=request.getAttribute("error") %></p>
	<%}if(request.getAttribute("log")!=null){ %>
	<p>Thank You: <%=request.getAttribute("log") %></p> 
	<%} %>
	
	<p>Username: <input type="text" name="user" size="30"/></p>
	<p>Password: <input type="password" name="password" size="30"/></p>
	
	<p ><input type="submit" value="Submit"></p>
	
	</form>
	</center>
</body>
</html>