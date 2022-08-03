<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Participants</title>
</head>
<body>

	<h3>List of Participants</h3>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Phone</th>
				<th>Email</th>
				<th>BatchID Class</th>
				<th>Class Name</th>
				<th>Preferred Time</th>
				<th>Slot</th>
				<th>Update/Delete</th>
			</tr>
		</thead>
		<tbody>
		<%
		
	
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/gymmembership";
		Connection conn = DriverManager.getConnection(url, "admin", "root");
		System.out.println("[ViewParticipant JSP] Connection Created");
		
		Statement stmt = conn.createStatement();
		String query = "select p.pId, p.name, p.phone, p.email, p.bId, b.batchname, b.preferredTime, b.slot from Participant p join Batch b on (p.bid = b.bid);";
		ResultSet rs=stmt.executeQuery(query);
	while(rs.next())
	{

%>
			
				<tr>
					<td><%=rs.getInt("p.pId")%></td>
					<td><%=rs.getString("p.name")%></td>
					<td><%=rs.getString("p.phone")%></td>
					<td><%=rs.getString("p.email")%></td>
					<td><%=rs.getInt("p.bId")%></td>
					<td><%=rs.getString("b.batchname")%></td>
					<td><%=rs.getString("b.preferredTime")%></td>
					<td><%=rs.getString("b.slot")%></td>
					<td><a href="UpdateParticipant.jsp?id=<%=rs.getInt("p.pId")%>">Update</a>
						| <a href="DeleteParticipant.jsp?id=<%=rs.getInt("p.pId")%>">Delete</a></td>
				</tr>
			<% } %>
				</tbody>
	</table>
</body>
</html>