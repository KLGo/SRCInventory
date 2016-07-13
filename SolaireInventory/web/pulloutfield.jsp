<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:useBean id="Pull" type="java.sql.ResultSet" scope="request"/>
<jsp:useBean id="Names" type="java.sql.ResultSet" scope="request"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="design.css">
<script type="text/javascript">

</script>
<title>TSSR Inventory - Pull Out Page</title>
</head>
<body class="background">

<ul class="ul">
  <li class="li"><a class="lia" href="Inventoryproc.jsp">INVENTORY</a></li>
  <li class="li"><a class="lia" href="pullout.jsp">PULL OUT</a></li>
  <li class="li"><a class="lia" href="putin.jsp">RETURN</a></li>
  <li class="lii"><a class="lia" href="logoutprocess.html">LOG OUT</a></li>
</ul>
<div class="divapull">
	<h2><center>PULL OUT ITEMS</center></h2>
	
	<table border="1" align="center" cellpadding="7" cellspacing="5">
		<tr>
			<th width="20%" align="center">Date OF PULL OUT</th>
			<th align="center">Name/Tech</th>
			<th align="center">Item Pull Out</th>
			<th align="center">Serial Number/COMP</th>
			<th align="center">Counts</th>
			<th align="center">Location of Deployment</th>
		</tr>
		
			<% 
				while(Pull.next()) {	
			%>
				<tr>
					<td><%=Pull.getString("Date")%></td>
					<td><%=Pull.getString("Tech")%></td>
					<td><%=Pull.getString("Item")%></td>
					<td><%=Pull.getString("Serial")%></td>
					<td><%=Pull.getInt("Counts")%></td>
					<td><%=Pull.getString("LOD")%></td>
				</tr>			
	<% } %>
		
	</table>
	</div>
	
	
	<div class="divapullnav">
	<form action="addPull.jsp" method="post" name="pull">
	<h3>PullOut an Item:</h3>
	<p>Date: <input type="DATE" name="date" size="15"/></p>
	<p>Technician: <input type="text" name="tech" size="15" runat="server" class="alpha" pattern="[a-zA-Z]{6,25}" ></p>
	<p> Item PullOUt:
	<select name="ID">
	<%while(Names.next()){ %>
	<option value="<%=Names.getInt("IdOther")%>|<%=Names.getString("Type")%>">
	<%=Names.getString("Description") %></option>
	
	<%} %>
	</select></p>
	<p>Serial Number/COMP: <input type="text" name="serial" size="20"></p>
	<p>Counts: <input type="text" name="counts" size="5" onkeypress='return event.charCode >= 48 && event.charCode <= 57'></p>
	<p>Location of Deployment: <input type="text" name="LOD" size="50"></p>
	<p><input type="submit" value="ADD ITEM" onclick="allLetter(document.pull.tech)"></p>
	</form>
	</div>
	
</body>
</html>