package com.EasyCab;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitializingServlet
 */
public class InitializingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static ActivatedObjects ao;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitializingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		ao = new ActivatedObjects();
		ActivatedObjects.addDriver(ActivatedObjects.driver, "driver001", 20, 20);
		ActivatedObjects.addDriver(ActivatedObjects.driver, "driver002", 30, 30);
		String message = "all information";
		request.setAttribute("information", message);
		out.println(message);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
		
	}
	
	/*public void printCustomer(java.util.HashMap<String, CustomerBean>){
		
	}
	*/


}
