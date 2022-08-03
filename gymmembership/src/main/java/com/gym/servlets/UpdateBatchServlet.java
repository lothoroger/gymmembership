package com.gym.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.gym.db.DB;
import com.gym.model.Batch;

/**
 * Servlet implementation class UpdateBatchServlet
 */
public class UpdateBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Update Batch SErvelet serated");
		Batch bt = new Batch();
		int bid = Integer.parseInt(request.getParameter("txtBid"));
        String batchname = request.getParameter("txtBatchName");
        String preferredTime = request.getParameter("txtPreferredTime");
        String slot = request.getParameter("txtSlot");
		System.out.println("[UpdateBatchServlet] Details: "+batchname+" "+preferredTime+" "+slot);

		bt.batchname=batchname;
		bt.preferredTime=preferredTime;
		bt.slot=slot;
		
		
		
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<center><h3>Update Batch Servlet</h3>");
	
		DB db = new DB();
		db.createConnection();
		pw.print("<h3>Update id = "+ bid+" Details: "+batchname+" "+preferredTime+" "+slot+"</h3>");
		
		db.updateBatch(bid,bt);
	     
		 db.closeConnection();
		pw.print(bt);
		pw.print("<h3>[UpdateBatchServlet]  Updated Successful</h3>");
		pw.print("</center>");
		
	 
	
	}

}

