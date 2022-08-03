package com.gym.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import com.gym.db.DB;
import com.gym.model.Participant;

import jakarta.servlet.*;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddParticipantServlet
 */
public class AddParticipantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 @Override
	    public void init(ServletConfig config) throws ServletException {
	    	// TODO Auto-generated method stub
	    	super.init();
	    	System.out.println("[AddParticipantServlet] Initialized");
	    }
	    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Participant pct = new Participant();
		String name = request.getParameter("txtName");
        String phone = request.getParameter("txtPhone");
        String email = request.getParameter("txtEmail");
        String bid = request.getParameter("txtBid");
		System.out.println("[AddParticipant Servlet] Details: "+name+" "+phone+" "+email+" batchId: "+bid);

		pct.name=name;
		pct.phone=phone;
		pct.email=email;
		pct.bId=Integer.parseInt(bid);
		
		
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<center><h3>AddParticipant Servlet</h3>");

		DB db = new DB();
		db.createConnection();
		int result = db.addParticipant(pct);

		response.setContentType("text/html");
		String loginTimeStamp = new Date().toString();
		if (result >=0) {
		pw.print("<h3>Added Participant: "+name+" "+phone+" "+email+" batchId: "+bid+"</h3>");
   
   	 db.closeConnection();
		pw.print(pct);
		pw.print("<h3>[AddParticipantServlet]  Updated Successful</h3>");
		} else {
		pw.print("<h3>[AddParticipantServlet] not successful");
		}
		
		pw.print("</center>");
	     	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("[AddParticipantServlet] - destroy executed");
	}
}
