package com.gym.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.gym.db.DB;

/**
 * Servlet implementation class DeleteParticipantServlet
 */
public class DeleteParticipantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid = Integer.parseInt(request.getParameter("txtPid"));
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.print("<center>");
		
		
		
		DB db = new DB();
		db.createConnection();
		int result = db.deleteParticipant(pid);
		
		if (result>=0) {
			pw.print("<h3>[DeleteServlet] Participant Deleted Successfully</h3>");
		} else {
			pw.print("<h3>[DeleteServlet] Participant was not deleted!</h3>");
		}
		pw.print("</center>");
		
				
		
		
		
		
	}

}
