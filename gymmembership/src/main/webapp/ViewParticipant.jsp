<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="com.gym.db.DB" %>

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
				<th>Update/Delete</th>
			</tr>
		</thead>
		<tbody>
		<%
		
		DB db = new DB();
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/gymmembership";
		Connection conn = DriverManager.getConnection(url, "admin", "root");
		System.out.println("[ViewParticipant JSP] Connection Created");
		
		Statement stmt = conn.createStatement();
		String query = "select * from Participant";
		ResultSet rs=stmt.executeQuery(query);
	while(rs.next())
	{

%>
			
				<tr>
					<td><%=rs.getInt("pId")%></td>
					<td><%=rs.getString("name")%></td>
					<td><%=rs.getString("phone")%></td>
					<td><%=rs.getString("email")%></td>
					<td><%=rs.getInt("bId")%></td>
					<td><a href="UpdateParticipant.jsp?id=<%=rs.getInt("pId")%>">Update</a>
						| <a href="DeleteParticipant.jsp?id=<%=rs.getInt("pId")%>">Delete</a></td>
				</tr>
			<% } %>
				</tbody>
	</table>
</body>
</html>