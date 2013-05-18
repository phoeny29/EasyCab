package com.EasyCab;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		// StringBuffer message = new StringBuffer();
		PrintWriter out = response.getWriter();
		String message = " ";
		java.util.Map<String, String[]> submission = request.getParameterMap();
		String userName = submission.get("userName")[0];
		String password = submission.get("password")[0];
		String firstName = submission.get("firstName")[0];
		String lastName = submission.get("lastName")[0];
		
		String dbUser = "phoenydb";
		String dbPassword = "xx58789thriller";
		boolean occupied = false;
		try {
			OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@//phoenydb.cb5gxrl1hgwj.us-east-1.rds.amazonaws.com:1521/phoenydb");
			ods.setUser(dbUser);
			ods.setPassword(dbPassword);
			Connection conn = ods.getConnection();

			String query = new String();
			Statement s = conn.createStatement();
			query = "select username from users where username ='" + userName + "'";
			ResultSet r = s.executeQuery(query);
			while (r.next()) {
				System.out.println(r.getString(1));
				occupied = true;
			}
			if (!occupied) {
				String query2 = new String();
				Statement s2 = conn.createStatement();
				query2 = "insert into users values('" + userName + "','"	+ password + "','" + firstName + "','" + lastName + "')";
				System.out.println(query2);
				s2.executeQuery(query2);
				s2.close();
			}
			r.close();
			s.close();
			conn.close();

		} catch (Exception e) {
			out.println("The database could not be accessed.<br>");
			out.println("More information is available as follows:<br>");
			e.printStackTrace(out);
		}
		if (!occupied) {
			message = "Congratulations  " + firstName + " " + lastName
					+ "   -----" + userName;
			
		} else {
			message = "sorry, " + userName + " has been already registered";

		}
		request.setAttribute("message", message);
		out.println(message);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
