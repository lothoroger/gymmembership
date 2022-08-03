<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="com.gym.db.DB" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Batch</title>
</head>
<body>
	<center>
		<table cellpadding=3 cellspacing=3>
			<tr>
				<th style="background-color: orange;" colspan=2>Batch Update JSP</th>
			</tr>
		<%
	
		String id = request.getParameter("id");
	
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/gymmembership";
		Connection conn = DriverManager.getConnection(url, "admin", "root");
		System.out.println("[UpdateBatch JSP] Connection Created");
		
		Statement stmt = conn.createStatement();
		String query = "select * from Batch where bid ="+id;
		ResultSet rs=stmt.executeQuery(query);
	while(rs.next())
	{

%>
			<form action="UpdateBatch" method="Post">
			<input type="hidden" name="txtBid" value=<%=rs.getInt("bId")%> />
		<tr>
				<td>update BatchClass Name:</td>
				<td><input type="text" name="txtBatchName"  value="<%=rs.getString("batchname")%>" /></td>
			</tr>
			
			<tr>
			<td>update Preferred Times:</td>
				<td><input type="text" name="txtPreferredTime" value="<%=rs.getString("preferredTime")%>" /></td>
					
			</tr>
			<tr>
				<td>update Slot:</td>
				<td><input type="text" name="txtSlot" value="<%=rs.getString("slot")%>" /></td>
				</tr>
		
			<tr>
				<td colspan="2"><input type="submit" value="Update Batch"></td>
			</tr>
			</form>
			<th style="background-color: orange;" colspan=2>@ Rogelio Lotho
				2022</th>

		</table>

		</form>
		
<%
}
conn.close();
%>
</body>
</html>



	