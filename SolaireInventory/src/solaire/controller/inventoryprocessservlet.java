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
 * Servlet implementation class inventoryprocessservlet
 */
@WebServlet("/Inventoryproc.jsp")
public class inventoryprocessservlet extends HttpServlet {
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
		doPost(request,response);
	}

	RequestDispatcher dispatcher;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session!=null){
		ResultSet cpu=SQLOperations.getAllCPU(connection);
		ResultSet mon=SQLOperations.getAllMonitor(connection);
		ResultSet lap=SQLOperations.getAllLaptop(connection);
		ResultSet Sca=SQLOperations.getAllScan(connection);
		ResultSet pri=SQLOperations.getAllPrinter(connection);
		ResultSet ser=SQLOperations.getAllService(connection);
		ResultSet acc=SQLOperations.getAllAccessories(connection);
		request.setAttribute("CPU", cpu);
		request.setAttribute("Monitor", mon);
		request.setAttribute("Laptop", lap);
		request.setAttribute("Printer", pri);
		request.setAttribute("Service", ser);
		request.setAttribute("Accessories", acc);
		request.setAttribute("Scanner", Sca);
		
		dispatcher=request.getRequestDispatcher("inventory.jsp");
		dispatcher.forward(request,response);
		}else{
			request.setAttribute("error", "Session Invalid. Please Try Again");
			dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request,response);
		}
	}

}
