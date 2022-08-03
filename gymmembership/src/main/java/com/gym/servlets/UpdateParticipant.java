package com.gym.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.gym.db.DB;
import com.gym.model.Participant;


/**
 * Servlet implementation class UpdateParticipant
 */
public class UpdateParticipant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPut(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Participant pct = new Participant();
		int pid = Integer.parseInt(request.getParameter("txtPid"));
        String name = request.getParameter("txtName");
        String phone = request.getParameter("txtPhone");
        String email = request.getParameter("txtEmail");
        String bid = request.getParameter("txtBid");
		System.out.println("[UpdateParticipantServlet] Details: "+name+" "+phone+" "+email+" batchId: "+bid);

		pct.name=name;
		pct.phone=phone;
		pct.email=email;
		pct.bId=Integer.parseInt(bid);
		pct.pId=pid;
		
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<center><h3>Update Participant Servlet</h3>");
	
		DB db = new DB();
		db.createConnection();
		pw.print("<h3>Update id = "+ pid+" Details: "+name+" "+phone+" "+email+" batchId: "+bid+"</h3>");
		
		db.updateParticipant(pid,pct);
	     
		 db.closeConnection();
		pw.print(pct);
		pw.print("<h3>[UpdateParticipantServlet]  Updated Successful</h3>");
		pw.print("</center>");
		
	 
	
	}

}

