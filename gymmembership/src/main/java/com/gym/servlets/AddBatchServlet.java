package com.gym.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import com.gym.db.DB;
import com.gym.model.Batch;

/**
 * Servlet implementation class AddBatchServlet
 */
public class AddBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

		

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//doGet(request, response);
			String batchname = request.getParameter("txtBatchName");
			String preferredTime = request.getParameter("txtPreferredTime");
			String slot = request.getParameter("txtSlot");
			
			System.out.println("[AddBatchServlet] Details: "+batchname+" "+preferredTime+" "+slot);
			
			Batch bc = new Batch();
			bc.batchname = request.getParameter("txtBatchName");
			bc.preferredTime = request.getParameter("txtPreferredTime");
			bc.slot = request.getParameter("txtSlot"); 
		   
			DB db = new DB();
			db.createConnection();
			int result = db.addBatch(bc);

			response.setContentType("text/html");
			String loginTimeStamp = new Date().toString();
			
			String htmlResponse = "<center>[AddBatchServlet] Thank you for adding Batch <h3>"+batchname+"</h3> Preferred Time: <h3>"+preferredTime+" "+slot+"</h3><p>Time submited: "+loginTimeStamp+"</p></center>";
			PrintWriter pw = response.getWriter();
			
			String message = (result >= 0 ) ? "Batch Entry Created Successfuly": "[AddBatchServlet doPost] Insert failed error";
			
		
			System.out.println("Step 3: [AddBatchServlet] "+message);
			pw.println(htmlResponse); 
			db.closeConnection();
		}
		
	
		
		
		

	

	}