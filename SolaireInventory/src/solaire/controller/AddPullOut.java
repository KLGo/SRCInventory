package solaire.controller;

import java.io.IOException;
import java.sql.Connection;
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

import solaire.model.SolaireBean;
import solaire.utility.sql.SQLOperations;

/**
 * Servlet implementation class inventoryprocessservlet
 */
@WebServlet("/addPull.jsp")
public class AddPullOut extends HttpServlet {
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
		String date="", tech="",LOD="", serial="", type="";
		int id, counts=0;
		String[] t= new String[3];
		SolaireBean up= new SolaireBean();
		HttpSession session=request.getSession(false);
		if(session!=null){
		
		
		if(request.getParameter("date")!=null&&request.getParameter("date").trim().length()>0&&request.getParameter("tech")!=null&&request.getParameter("tech").trim().length()>0&&
				request.getParameter("LOD")!=null&&request.getParameter("LOD").trim().length()>0){
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			date=request.getParameter("date");
			Date Date=new Date();
			   System.out.println(dateFormat.format(Date));
			   String d2=dateFormat.format(Date);
			   int current =Integer.parseInt(d2.replaceAll("[\\s\\-()]", ""));
			   int input =Integer.parseInt(date.replaceAll("[\\s\\-()]", ""));
			 if(current>=input){
			 t = request.getParameter("ID").split("|", 3);
			id=Integer.parseInt(t[0]);
			type=t[2];
			tech=request.getParameter("tech");
			counts=Integer.parseInt(request.getParameter("counts"));
			LOD=request.getParameter("LOD");
			serial=request.getParameter("serial");
			switch(type){
			case "CPU":up=SQLOperations.PULLCPU(id, counts, connection);break;
			case "Mon": up=SQLOperations.PULLMon(id, counts, connection);break;
			case "Lap": up=SQLOperations.PULLLAP(id, counts, connection);break;
			case "Ptr": up=SQLOperations.PULLPri(id, counts, connection);break;
			case "Scn":up=SQLOperations.PULLSca(id, counts, connection) ;break;
			case "Acs": up=SQLOperations.PULLAcs(id, counts, connection);break;
			case "SU": up=SQLOperations.PULLSU(id, counts, connection) ;break;
			}
			up.setCounts(counts);
			up.setDate(date);
			up.setLOD(LOD);
			up.setTech(tech);
			up.setSerial(serial);
			
		for(int i=0;i<t.length;i++){
			System.out.println(t[i]);
		}
		
		System.out.println(t[0]);
		System.out.println(t[2]);
		System.out.println();
		}
			SQLOperations.addPull(date, tech, up.getDesc(), serial, counts, LOD, connection);
				dispatcher=request.getRequestDispatcher("pullout.jsp");
				dispatcher.forward(request,response);
			
		}else{
			up.setError("INPUT DATE IS GREATER THAN CURRENT DATE. PLEASE TRY AGAIN");
			dispatcher=request.getRequestDispatcher("pullout.jsp");
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
