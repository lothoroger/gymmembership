<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="com.gym.db.DB" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Batch</title>
</head>
<body>

	<h3>List of Batch Classes</h3>
	<table>
		<thead>
			<tr>
				<th>Batch ID</th>
				<th>Class Name</th>
				<th>Preferred Time</th>
				<th>Slot</th>
				<th>Update/Delete</th>
			</tr>
		</thead>
		<tbody>
		<%
		
		DB db = new DB();
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/gymmembership";
		Connection conn = DriverManager.getConnection(url, "admin", "root");
		System.out.println("[ViewBatch JSP] Connection Created");
		
		Statement stmt = conn.createStatement();
		String query = "select * from Batch";
		ResultSet rs=stmt.executeQuery(query);
	while(rs.next())
	{

%>
			
				<tr>
					<td><%=rs.getInt("bId")%></td>
					<td><%=rs.getString("batchname")%></td>
					<td><%=rs.getString("preferredTime")%></td>
					<td><%=rs.getString("slot")%></td>
					<td><a href="UpdateBatch.jsp?id=<%=rs.getInt("bId")%>">Update</a>
						| <a href="DeleteBatch.jsp?id=<%=rs.getInt("bId")%>">Delete</a></td>
				</tr>
			<% } %>
				</tbody>
	</table>
</body>
</html>