<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:useBean id="Put" type="java.sql.ResultSet" scope="request"/>
    <jsp:useBean id="Names" type="java.sql.ResultSet" scope="request"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="design.css">
<title>TSSR Inventory - Return Page</title>
</head>
<body class="background">

<ul class="ul">
  <li class="li"><a class="lia" href="Inventoryproc.jsp">INVENTORY</a></li>
  <li class="li"><a class="lia" href="pullout.jsp">PULL OUT</a></li>
  <li class="li"><a class="lia" href="putin.jsp">RETURN</a></li>
  <li class="lii"><a class="lia" href="logoutprocess.html">LOG OUT</a></li>
</ul>
<div class="divaput">
	<h2><center>PUT IN ITEMS</center></h2>
	
	<table border="1" align="center" cellpadding="7" cellspacing="5">
		<tr>
			<th width="20%" align="center">Date Of Return</th>
			<th align="center">Name/Tech</th>
			<th align="center">Item Put In</th>
			<th align="center">Serial Number</th>
			<th align="center">Comp ID</th>
			<th align="center">Count</th>
			<th align="center">Remarks</th>
		</tr>
		
			<% 
				while(Put.next()) {	
			%>
				<tr>
					<td><%=Put.getString("Date")%></td>
					<td><%=Put.getString("Tech")%></td>
					<td><%=Put.getString("Item")%></td>
					<td><%=Put.getString("Serial")%></td>
					<td><%=Put.getString("CompID")%></td>
					<td><%=Put.getString("Count")%></td>
					<td><%=Put.getString("Remarks")%></td>
				</tr>			
	<% } %>
		
	</table>
	</div>
	
	
	<div class="divaputnav">
	<form action="addPut.jsp" method="post">
	<h3>Put in Item for Return:</h3>
	<p>Date: <input type="date" name="date" size="15"/></p>
	<p>Technician: <input type="text" name="tech" size="15" pattern="[a-zA-Z]{6,25}"/></p>
	<p> Item PullOUt:
	<select name="ID">
	<%while(Names.next()){ %>
	<option value="<%=Names.getInt("IdOther")%>|<%=Names.getString("Type")%>">
	<%=Names.getString("Description") %></option>
	
	<%} %>
	</select></p>
	<p>Serial Number: <input type="text" name="serial" size="20"></p>
	<p>COMP: <input type="text" name="comp" size="20"></p>
	<p>Counts: <input type="text" name="counts" size="5" onkeypress='return event.charCode >= 48 && event.charCode <= 57'></p>
	
	<p>Remarks: <input type="text" name="remark" size="50"></p>
	<p><input type="submit" value="ADD ITEM"></p>
	
	</form>
	</div>
</body>
</html>