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
public class DeleteBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("[DeleteBatchServlet] called");
		int bid = Integer.parseInt(request.getParameter("txtBid"));
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.print("<center>");
		
		
		
		DB db = new DB();
		db.createConnection();
		int result = db.deleteBatch(bid);
		
		if (result>=0) {
			pw.print("<h3>[DeleteBatchServlet]  Deleted Successfully</h3>");
		} else {
			pw.print("<h3>[DeleteBatchServlet] Participant was not deleted!</h3>");
		}
		pw.print("</center>");
		
				
		
		
		
		
	}

}
