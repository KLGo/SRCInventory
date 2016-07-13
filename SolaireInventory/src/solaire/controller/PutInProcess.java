package solaire.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import solaire.utility.sql.SQLOperations;

/**
 * Servlet implementation class PutInProcess
 */
@WebServlet("/putin.jsp")
public class PutInProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection;
	public void init() throws ServletException {
		connection = SQLOperations.getConnection();
		
		if (connection != null) {
			getServletContext().setAttribute("dbConnection", connection);
			System.out.println("connection is READY.");
		} else {
			System.err.println("connection is NULL.");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	RequestDispatcher dispatcher;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session!=null){
		ResultSet PutIn=SQLOperations.getAllPutIn(connection);
		request.setAttribute("Put", PutIn);
		ResultSet Names=SQLOperations.getAllNames(connection);
		request.setAttribute("Names", Names);
		
		dispatcher=request.getRequestDispatcher("putinfield.jsp");
		dispatcher.forward(request,response);
		}
		else{
			request.setAttribute("error", "Invalid Username or Password. Please Try Again");
			dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request,response);
		}
	}

}
