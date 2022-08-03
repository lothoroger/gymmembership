package com.gym.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gym.db.DB;
import com.gym.model.Participant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAll
 */
public class ViewAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	DB db = new DB();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.print("<center>");
		
		db.createConnection();
		ArrayList<Participant>  listpt = db.getParticipant();
		db.closeConnection();
		StringBuffer buffer = new StringBuffer();
		if (listpt.size()>0) {
 		buffer.append("<table>");
		buffer.append("<tr>");
		buffer.append("<td>ID</td>");
		buffer.append("<td>Name</td>");
		buffer.append("<td>Phone</td>");
		buffer.append("<td>Email</td>");
		buffer.append("<td>BatchID Class</td>");
		buffer.append("<td>Update/Delete</td>");
		buffer.append("</tr>");	
		for (Participant pct: listpt) {
			
			buffer.append("<tr>");
			buffer.append("<td>"+pct.pId+"</td>");
			buffer.append("<td>"+pct.name+"</td>");
			buffer.append("<td>"+pct.phone+"</td>");
			buffer.append("<td>"+pct.email+"</td>");
			buffer.append("<td>"+pct.bId+"</td>");
			buffer.append("<td><a href='Update?id="+pct.pId+"'>Update</a> | <a href='Delete?id="+pct.pId+"'>Delete</a></td>");
			buffer.append("</tr>");		
			
		}
		buffer.append("</table>");	
	
		} else {
			buffer.append("<h3>No Participants Found</h3>");
		}
		
		pw.print(buffer.toString());
		pw.print("</center");
	}
	
	
	
	private void listParticipant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Participant> listParty = db.getParticipant();
		request.setAttribute("listParticipant", listParty);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewParticipant.jsp");
		dispatcher.forward(request, response);
	}

}
