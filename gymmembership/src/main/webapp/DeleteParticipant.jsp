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
<title>Update Participant</title>
</head>
<body>
	<center>
		<table cellpadding=3 cellspacing=3>
			<tr>
				<th style="background-color: orange;" colspan=2>Particpant Delete JSP</th>
			</tr>
		<%
	
		String id = request.getParameter("id");
	
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/gymmembership";
		Connection conn = DriverManager.getConnection(url, "admin", "root");
		System.out.println("[Delete Participant JSP] Connection Created");
		
		Statement stmt = conn.createStatement();
		String query = "select * from Participant where pid ="+id;
		ResultSet rs=stmt.executeQuery(query);
	while(rs.next())
	{

%>
			<form action="DeleteParticipant" method="Post">
			<input type="hidden" name="txtPid" value=<%=rs.getInt("pId")%> />
		<tr>
				<td>Delete Name:</td>
				<td><%=rs.getString("name")%></td>
			</tr>
			<tr>
				<td>Delete Phone:</td>
				<td><%=rs.getString("phone")%></td>
			</tr>
			<tr>
				<td>Delete Email:</td>
				<td><%=rs.getString("email")%></td>
			</tr>
			<tr>
				<td>Delete BatchId:</td>
				<td><%=rs.getString("bId")%></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Delete Participant"></td>
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