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
@WebServlet("/addPut.jsp")
public class AddPutIn extends HttpServlet {
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
		String date="", tech="",Remarks="", serial="", type="", compID="";
		int id, counts=0;
		String[] t= new String[3];
		SolaireBean up= new SolaireBean();
		
		HttpSession session=request.getSession(false);
		if(session!=null){
		
		if(request.getParameter("date")!=null&&request.getParameter("date").trim().length()>0&&request.getParameter("tech")!=null&&request.getParameter("tech").trim().length()>0){
			 t = request.getParameter("ID").split("|", 3);
			id=Integer.parseInt(t[0]);
			type=t[2];
			date=request.getParameter("date");
			tech=request.getParameter("tech");
			if(request.getParameter("serial")!=null&&request.getParameter("serial").trim().length()>0){
				serial=request.getParameter("serial");
				counts=1;
			}
			if(request.getParameter("comp")!=null&&request.getParameter("comp").trim().length()>0){
				compID=request.getParameter("comp");
				counts=1;
			}
			else{
				counts=Integer.parseInt(request.getParameter("counts"));
			}
			
			Remarks=request.getParameter("remark");
			
			switch(type){
			case "CPU":up=SQLOperations.PUTCPU(id, counts, connection);break;
			case "Mon": up=SQLOperations.PUTMon(id, counts, connection);break;
			case "Lap": up=SQLOperations.PUTLap(id, counts, connection);break;
			case "Ptr": up=SQLOperations.PUTPrin(id, counts, connection);break;
			case "Scn":up=SQLOperations.PUTSca(id, counts, connection) ;break;
			case "Acs": up=SQLOperations.PUTAcs(id, counts, connection);break;
			case "SU": up=SQLOperations.PUTSU(id, counts, connection) ;break;
			}
			up.setCounts(counts);
			up.setDate(date);
			
			up.setTech(tech);
			up.setSerial(serial);
			
		for(int i=0;i<t.length;i++){
			System.out.println(t[i]);
		}
		
		System.out.println(t[0]);
		System.out.println(t[2]);
		System.out.println();
		}
		
		   
			SQLOperations.addPut(date, tech, up.getDesc(), serial, compID, counts, Remarks, connection);
				dispatcher=request.getRequestDispatcher("putin.jsp");
				dispatcher.forward(request,response);
			
		}else{
			request.setAttribute("error", "Session Invalid. Please Try Again");
			dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request,response);
		}
	}
	

}
