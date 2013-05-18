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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		PrintWriter out = new PrintWriter(response.getOutputStream());
		String message = " ";
		java.util.Map<String, String[]> submission = request.getParameterMap();
		String userName = submission.get("userName")[0];
		String password = submission.get("password")[0];

		String dbUser = "phoenydb";
		String dbPassword = "xx58789thriller";
		boolean authenticated = false;
		try {
			OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@//phoenydb.cb5gxrl1hgwj.us-east-1.rds.amazonaws.com:1521/phoenydb");
			ods.setUser(dbUser);
			ods.setPassword(dbPassword);
			Connection conn = ods.getConnection();

			String query = new String();
			Statement s = conn.createStatement();
			query = "select username from users where username ='" + userName
					+ "' and password='" + password + "'";
			ResultSet r = s.executeQuery(query);
			while (r.next()) {
				System.out.println(r.getString(1));
				authenticated = true;
			}
			r.close();
			s.close();
			conn.close();

		} catch (Exception e) {
			out.println("The database could not be accessed.<br>");
			out.println("More information is available as follows:<br>");
			e.printStackTrace(out);
		}
		if (!authenticated) {
			message = "fail";

		} else {
			message = "success";

		}
		request.setAttribute("message", message);
		out.println(message);
		out.close();

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
