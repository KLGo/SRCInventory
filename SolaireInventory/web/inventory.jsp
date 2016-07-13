<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:useBean id="CPU" type="java.sql.ResultSet" scope="request"/>
<jsp:useBean id="Monitor" type="java.sql.ResultSet" scope="request"/>
<jsp:useBean id="Laptop" type="java.sql.ResultSet" scope="request"/>
<jsp:useBean id="Printer" type="java.sql.ResultSet" scope="request"/>
<jsp:useBean id="Service" type="java.sql.ResultSet" scope="request"/>
<jsp:useBean id="Scanner" type="java.sql.ResultSet" scope="request"/>
<jsp:useBean id="Accessories" type="java.sql.ResultSet" scope="request"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="design.css">

<title>TSSR Inventory - Home Page</title>
</head>
<body class="background">

<ul class="ul">
  <li class="li"><a class="lia" href="Inventoryproc.jsp">INVENTORY</a></li>
  <li class="li"><a class="lia" href="pullout.jsp">PULL OUT</a></li>
  <li class="li"><a class="lia" href="putin.jsp">RETURN</a></li>
  <li class="lii"><a class="lia" href="logoutprocess.html">LOG OUT</a></li>
</ul>
<div class="divb">
	<h2 class="hdr">CPU</h2>
	
	<table border="1" align="center" cellpadding="7" cellspacing="5">
		<tr>
			<th width="50%" align="center">Description</th>
			<th align="center">Total no. of Stocks</th>
			<th align="center">No. of Pull Out</th>
			<th align="center">No. of Return</th>
			<th align="center">Remaining ITEMS</th>
		</tr>
		
			<% 
				while(CPU.next()) {	
			%>
				<tr>
					<td><%=CPU.getString("Description")%></td>
					<td><%=CPU.getInt("Stocks")%></td>
					<td><%=CPU.getInt("PullOut")%></td>
					<td><%=CPU.getInt("NumReturn")%></td>
					<td><%=CPU.getInt("RemainingItems")%></td>
				</tr>			
	<% } %>
		
	</table>
	<h2 class="hdr">Monitor</h2>
	
	<table border="1" align="center" cellpadding="7" cellspacing="5">
		<tr>
			<th width="50%"  align="center">Description</th>
			<th align="center">Total no. of Stocks</th>
			<th align="center">No. of Pull Out</th>
			<th align="center">No. of Return</th>
			<th align="center">Remaining ITEMS</th>
		</tr>
		
			<% 
				while(Monitor.next()) {	
			%>
				<tr>
					<td><%=Monitor.getString("Description")%></td>
					<td><%=Monitor.getInt("Stocks")%></td>
					<td><%=Monitor.getInt("PullOut")%></td>
					<td><%=Monitor.getInt("NumReturn")%></td>
					<td><%=Monitor.getInt("RemainingItems")%></td>
				</tr>			
	<% } %>
		
	</table>
	<h2 class="hdr">Laptop</h2>
	
	<table border="1" align="center" cellpadding="7" cellspacing="5">
		<tr>
			<th width="50%" align="center">Description</th>
			<th align="center">Total no. of Stocks</th>
			<th align="center">No. of Pull Out</th>
			<th align="center">No. of Return</th>
			<th align="center">Remaining ITEMS</th>
		</tr>
		
			<% 
				while(Laptop.next()) {	
			%>
				<tr>
					<td><%=Laptop.getString("Description")%></td>
					<td><%=Laptop.getInt("Stocks")%></td>
					<td><%=Laptop.getInt("PullOut")%></td>
					<td><%=Laptop.getInt("NumReturn")%></td>
					<td><%=Laptop.getInt("RemainingItems")%></td>
				</tr>			
	<% } %>
		
	</table>
	<h2 class="hdr">Printer</h2>
	
	<table border="1" align="center" cellpadding="7" cellspacing="5">
		<tr>
			<th width="50%" align="center">Description</th>
			<th align="center">Total no. of Stocks</th>
			<th align="center">No. of Pull Out</th>
			<th align="center">No. of Return</th>
			<th align="center">Remaining ITEMS</th>
		</tr>
		
			<% 
				while(Printer.next()) {	
			%>
				<tr>
					<td><%=Printer.getString("Description")%></td>
					<td><%=Printer.getInt("Stocks")%></td>
					<td><%=Printer.getInt("PullOut")%></td>
					<td><%=Printer.getInt("NumReturn")%></td>
					<td><%=Printer.getInt("RemainingItems")%></td>
				</tr>			
	<% } %>
		
	</table>
	<h2 class="hdr">Scanner</h2>
	
	<table border="1" align="center" cellpadding="7" cellspacing="5">
		<tr>
			<th width="50%" align="center">Description</th>
			<th align="center">Total no. of Stocks</th>
			<th align="center">No. of Pull Out</th>
			<th align="center">No. of Return</th>
			<th align="center">Remaining ITEMS</th>
		</tr>
		
			<% 
				while(Scanner.next()) {	
			%>
				<tr>
					<td><%=Scanner.getString("Description")%></td>
					<td><%=Scanner.getInt("Stocks")%></td>
					<td><%=Scanner.getInt("PullOut")%></td>
					<td><%=Scanner.getInt("NumReturn")%></td>
					<td><%=Scanner.getInt("RemainingItems")%></td>
				</tr>			
	<% } %>
		
	</table>
	<h2 class="hdr">Accessories</h2>
	
	<table border="1" align="center" cellpadding="7" cellspacing="5">
		<tr>
			<th width="50%" align="center">Description</th>
			<th align="center">Total no. of Stocks</th>
			<th align="center">No. of Pull Out</th>
			<th align="center">No. of Return</th>
			<th align="center">Remaining ITEMS</th>
		</tr>
		
			<% 
				while(Accessories.next()) {	
			%>
				<tr>
					<td><%=Accessories.getString("Description")%></td>
					<td><%=Accessories.getInt("Stocks")%></td>
					<td><%=Accessories.getInt("PullOut")%></td>
					<td><%=Accessories.getInt("NumReturn")%></td>
					<td><%=Accessories.getInt("RemainingItems")%></td>
				</tr>			
	<% } %>
		
	</table>
	<h2 class="hdr">Service Unit / DEMO</h2>
	
	<table border="1" align="center" cellpadding="7" cellspacing="5">
		<tr>
			<th width="50%" align="center">Description</th>
			<th align="center">Total no. of Stocks</th>
			<th align="center">No. of Pull Out</th>
			<th align="center">No. of Return</th>
			<th align="center">Remaining ITEMS</th>
		</tr>
		
			<% 
				while(Service.next()) {	
			%>
				<tr>
					<td><%=Service.getString("Description")%></td>
					<td><%=Service.getInt("Stocks")%></td>
					<td><%=Service.getInt("PullOut")%></td>
					<td><%=Service.getInt("NumReturn")%></td>
					<td><%=Service.getInt("RemainingItems")%></td>
				</tr>			
	<% } %>
		
	</table>
	</div>
	
	<div class="sidenav">
	<form action="AddItem.html" method="post">

	<h4>Add a new item</h4>
	<p>Description/Name: <input type="text" name="desc" size="50"/></p>
	<p> Type of Equipment:
	<select name="type">
	<option value="null">Select a type</option>
	<option value="CPU">CPU</option>
	<option value="Mon">Monitor</option>
	<option value="Lap">Laptop</option>
	<option value="Ptr">Printer</option>
	<option value="Scn">Scanner</option>
	<option value="Acs">Accessories</option>
	<option value="SU">Service Unit/DEMO</option>
	</select></p>
	<p>Total No. Of Stocks: <input type="text" name="Stocks" size="10"onkeypress='return event.charCode >= 48 && event.charCode <= 57'></p>
	<p><input type="submit" value="ADD ITEM"></p>
	</form>
	</div>
	
	<div class="sidenavv">
	<h4>Generate PDF</h4>
	<form action="generate.jsp" method="post">
	<p><input type="submit" value="Generate PDF"></p>
	</form>
	</div>
	
</body>
</html>