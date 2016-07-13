package solaire.Maintenance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import solaire.model.*;
import solaire.utility.sql.SQLOperations;


@WebServlet("/loginprocess.html")
public class loginprocess extends HttpServlet {
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
		String username="", password="";
		if(request.getParameter("user")!=null&&request.getParameter("user").trim().length()>0&&request.getParameter("password")!=null&&request.getParameter("password").trim().length()>0){
			username=request.getParameter("user");
			password=request.getParameter("password");
			SolaireBean d = new SolaireBean();
			d.setPassword(password);
			d.setUsername(username);
			if(SQLOperations.searchAdmin(d, connection)==true){
				HttpSession session=request.getSession();
				session.setAttribute("log", true);
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
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = "2016-07-15";
				Date Date=new Date();
				   System.out.println(dateFormat.format(Date));
				   String d2=dateFormat.format(Date);
				   int t =Integer.parseInt(d2.replaceAll("[\\s\\-()]", ""));
				   int f =Integer.parseInt(date.replaceAll("[\\s\\-()]", ""));
				   System.out.println(t);
				   System.out.println(f);
				   if(t<f){
					   System.out.println(" THE INPPUTED DATE IS GREATER THAN THE CURRENT DATE PLEASE TRY AGAIN");
				   }
				dispatcher=request.getRequestDispatcher("inventory.jsp");
				dispatcher.forward(request,response);
			}
			else{
				request.setAttribute("error", "Invalid Username or Password. Please Try Again");
				dispatcher=request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request,response);
			}
		}else{
			request.setAttribute("error", "Null Input. Please Try Again");
			dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request,response);}
	}

}
