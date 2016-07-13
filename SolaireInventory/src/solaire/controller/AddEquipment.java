package solaire.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import solaire.model.SolaireBean;
import solaire.utility.sql.SQLOperations;
import solaire.utility.sql.SQLOperations;
@WebServlet("/AddItem.html")
public class AddEquipment extends HttpServlet {
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
		String desc="";
		int stocks;
		String type="";
		HttpSession session=request.getSession(false);
		if(session!=null){
		if(request.getParameter("desc")!=null&&request.getParameter("desc").trim().length()>0&&request.getParameter("Stocks")!=null&&request.getParameter("Stocks").trim().length()>0&&request.getParameter("desc").contentEquals("null")==false){
			stocks = Integer.parseInt(request.getParameter("Stocks"));
			desc=request.getParameter("desc");
			type=request.getParameter("type");
			SolaireBean T=new SolaireBean();
			T.setDescrip(desc);
			T.setStock(stocks);
			ResultSet rs;
			
			switch(type){
			case "CPU":SQLOperations.addCPU(T, connection);T=SQLOperations.searchCPU(desc, connection);break;
			case "Mon":SQLOperations.addMon(T, connection);T=SQLOperations.searchMonitor(desc, connection) ;break;
			case "Lap":SQLOperations.addLap(T, connection);T=SQLOperations.searchLap(desc, connection) ;break;
			case "Ptr":SQLOperations.addPrint(T, connection);T=SQLOperations.searchPrint(desc, connection) ;break;
			case "Scn":SQLOperations.addScan(T, connection);T=SQLOperations.searchScan(desc, connection) ;break;
			case "Acs":SQLOperations.addAcs(T, connection);T=SQLOperations.searchAcs(desc, connection) ;break;
			case "SU":SQLOperations.addSU(T, connection);T=SQLOperations.searchSU(desc, connection) ;break;
			}
			SQLOperations.addName(T, type, connection);
			dispatcher=request.getRequestDispatcher("Inventoryproc.jsp");
			dispatcher.forward(request,response);
		}
		}
		else{
			request.setAttribute("error", "Session Invalid. Please Try Again");
			dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request,response);
		}
	}

}
