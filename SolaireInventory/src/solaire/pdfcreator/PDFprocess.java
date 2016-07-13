package solaire.pdfcreator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import solaire.utility.sql.SQLOperations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
@WebServlet("/generate.jsp")
public class PDFprocess extends HttpServlet {
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
		ResultSet cpu=SQLOperations.getAllCPU(connection);
		ResultSet mon=SQLOperations.getAllMonitor(connection);
		ResultSet lap=SQLOperations.getAllLaptop(connection);
		ResultSet Sca=SQLOperations.getAllScan(connection);
		ResultSet pri=SQLOperations.getAllPrinter(connection);
		ResultSet ser=SQLOperations.getAllService(connection);
		ResultSet acc=SQLOperations.getAllAccessories(connection);
		Document document = new Document();
		Font BOLD = new Font();
		BOLD.setStyle("bold");
		Paragraph header= new Paragraph("TSSR INVENTORY",BOLD);
		header.setAlignment(Element.ALIGN_CENTER);
		Paragraph head1= new Paragraph("CPU", BOLD);
		head1.setAlignment(Element.ALIGN_CENTER);
		Paragraph head2= new Paragraph("Laptop", BOLD);
		head2.setAlignment(Element.ALIGN_CENTER);
		Paragraph head3= new Paragraph("Monitor", BOLD);
		head3.setAlignment(Element.ALIGN_CENTER);
		Paragraph head4= new Paragraph("Scanner", BOLD);
		head4.setAlignment(Element.ALIGN_CENTER);
		Paragraph head5= new Paragraph("Printer", BOLD);
		head5.setAlignment(Element.ALIGN_CENTER);
		Paragraph head6= new Paragraph("Service", BOLD);
		head6.setAlignment(Element.ALIGN_CENTER);
		Paragraph head7= new Paragraph("Accessories", BOLD);
		head7.setAlignment(Element.ALIGN_CENTER);
		
		PdfPTable cpuT = new PdfPTable(new float[] { 2.5f, 1, 1.5f, 1, 1 });
		cpuT.setSpacingBefore(7);
		cpuT.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		cpuT.addCell("Description");
        cpuT.addCell("Total no. of Stocks");
        cpuT.addCell("No.of Items PullOut");
        cpuT.addCell("No. of Return");
        cpuT.addCell("Remaining Items");
        cpuT.setHeaderRows(1);
	  PdfPCell[] cells = cpuT.getRow(0).getCells(); 
	  for (int j=0;j<cells.length;j++){
	     cells[j].setBackgroundColor(BaseColor.ORANGE);
	  }
	  try{
	  while(cpu.next()) {
 	     cpuT.addCell(cpu.getString("Description"));          
 	     cpuT.addCell(""+cpu.getInt("Stocks"));
 	     cpuT.addCell(""+cpu.getInt("PullOut"));
 	     cpuT.addCell(""+cpu.getInt("NumReturn"));
 	     cpuT.addCell(""+cpu.getInt("RemainingItems"));
       }
	  }catch(SQLException e){
		  System.out.println("Exception Cpu:"+ e);
		  
	  }
	  PdfPTable lapT = new PdfPTable(new float[] { 2.5f, 1, 1.5f, 1, 1 });
	  lapT.setSpacingBefore(7);
	  lapT.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		lapT.addCell("Description");
      lapT.addCell("Total no. of Stocks");
      lapT.addCell("No.of Items PullOut");
      lapT.addCell("No. of Return");
      lapT.addCell("Remaining Items");
      lapT.setHeaderRows(1);
	  PdfPCell[] cells2 = lapT.getRow(0).getCells(); 
	  for (int j=0;j<cells2.length;j++){
	     cells2[j].setBackgroundColor(BaseColor.ORANGE);
	  }
	  try{
	  while(lap.next()) {
	     lapT.addCell(lap.getString("Description"));          
	     lapT.addCell(""+lap.getInt("Stocks"));
	     lapT.addCell(""+lap.getInt("PullOut"));
	     lapT.addCell(""+lap.getInt("NumReturn"));
	     lapT.addCell(""+lap.getInt("RemainingItems"));
     }
	  }catch(SQLException e){
		  System.out.println("Exception Lap:"+ e);
		  
	  }
	  PdfPTable monT = new PdfPTable(new float[] { 2.5f, 1, 1.5f, 1, 1 });
		monT.setSpacingBefore(7);
	  monT.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		monT.addCell("Description");
    monT.addCell("Total no. of Stocks");
    monT.addCell("No.of Items PullOut");
    monT.addCell("No. of Return");
    monT.addCell("Remaining Items");
    monT.setHeaderRows(1);
	  PdfPCell[] cells3 = monT.getRow(0).getCells(); 
	  for (int j=0;j<cells3.length;j++){
	     cells3[j].setBackgroundColor(BaseColor.ORANGE);
	  }
	  try{
	  while(mon.next()) {
	     monT.addCell(mon.getString("Description"));          
	     monT.addCell(""+mon.getInt("Stocks"));
	     monT.addCell(""+mon.getInt("PullOut"));
	     monT.addCell(""+mon.getInt("NumReturn"));
	     monT.addCell(""+mon.getInt("RemainingItems"));
   }
	  }catch(SQLException e){
		  System.out.println("Exception moni:"+ e);
		  
	  }
	  PdfPTable ScanT = new PdfPTable(new float[] { 2.5f, 1, 1.5f, 1, 1 });
		ScanT.setSpacingBefore(7);
	  ScanT.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		ScanT.addCell("Description");
    ScanT.addCell("Total no. of Stocks");
    ScanT.addCell("No.of Items PullOut");
    ScanT.addCell("No. of Return");
    ScanT.addCell("Remaining Items");
    ScanT.setHeaderRows(1);
	  PdfPCell[] cells4 = ScanT.getRow(0).getCells(); 
	  for (int j=0;j<cells4.length;j++){
	     cells4[j].setBackgroundColor(BaseColor.ORANGE);
	  }
	  try{
	  while(Sca.next()) {
	     ScanT.addCell(Sca.getString("Description"));          
	     ScanT.addCell(""+Sca.getInt("Stocks"));
	     ScanT.addCell(""+Sca.getInt("PullOut"));
	     ScanT.addCell(""+Sca.getInt("NumReturn"));
	     ScanT.addCell(""+Sca.getInt("RemainingItems"));
   }
	  }catch(SQLException e){
		  System.out.println("Exception Scan:"+ e);
		  
	  }
		
	  PdfPTable priT = new PdfPTable(new float[] { 2.5f, 1, 1.5f, 1, 1 });
		priT.setSpacingBefore(7);
	  priT.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		priT.addCell("Description");
    priT.addCell("Total no. of Stocks");
    priT.addCell("No.of Items PullOut");
    priT.addCell("No. of Return");
    priT.addCell("Remaining Items");
    priT.setHeaderRows(1);
	  PdfPCell[] cells5 = priT.getRow(0).getCells(); 
	  for (int j=0;j<cells5.length;j++){
	     cells5[j].setBackgroundColor(BaseColor.ORANGE);
	  }
	  try{
	  while(pri.next()) {
	     priT.addCell(pri.getString("Description"));          
	     priT.addCell(""+pri.getInt("Stocks"));
	     priT.addCell(""+pri.getInt("PullOut"));
	     priT.addCell(""+pri.getInt("NumReturn"));
	     priT.addCell(""+pri.getInt("RemainingItems"));
   }
	  }catch(SQLException e){
		  System.out.println("Exception Prin:"+ e);
		  
	  }
	  PdfPTable ServT = new PdfPTable(new float[] { 2.5f, 1, 1.5f, 1, 1 });
		ServT.setSpacingBefore(7);
	  ServT.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		ServT.addCell("Description");
    ServT.addCell("Total no. of Stocks");
    ServT.addCell("PullOut");
    ServT.addCell("No. of Return");
    ServT.addCell("Remaining Items");
    ServT.setHeaderRows(1);
	  PdfPCell[] cells6 = ServT.getRow(0).getCells(); 
	  for (int j=0;j<cells6.length;j++){
	     cells6[j].setBackgroundColor(BaseColor.ORANGE);
	  }
	  try{
	  while(ser.next()) {
	     ServT.addCell(ser.getString("Description"));          
	     ServT.addCell(""+ser.getInt("Stocks"));
	     ServT.addCell(""+ser.getInt("PullOut"));
	     ServT.addCell(""+ser.getInt("NumReturn"));
	     ServT.addCell(""+ser.getInt("RemainingItems"));
   }
	  }catch(SQLException e){
		  System.out.println("Exception Serv:"+ e);
		  
	  }
	  PdfPTable ACS = new PdfPTable(new float[] { 2.5f, 1, 1.5f, 1, 1 });
		ACS.setSpacingBefore(7);
	  ACS.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		ACS.addCell("Description");
    ACS.addCell("Total no. of Stocks");
    ACS.addCell("No.of Items PullOut");
    ACS.addCell("No. of Return");
    ACS.addCell("Remaining Items");
    ACS.setHeaderRows(1);
	  PdfPCell[] cells7 = ACS.getRow(0).getCells(); 
	  for (int j=0;j<cells7.length;j++){
	     cells7[j].setBackgroundColor(BaseColor.ORANGE);
	  }
	  try{
	  while(acc.next()) {
	     ACS.addCell(acc.getString("Description"));          
	     ACS.addCell(""+acc.getInt("Stocks"));
	     ACS.addCell(""+acc.getInt("PullOut"));
	     ACS.addCell(""+acc.getInt("NumReturn"));
	     ACS.addCell(""+acc.getInt("RemainingItems"));
   }
	  }catch(SQLException e){
		  System.out.println("Exception Acs:"+ e);
		  
	  }
	  try {
		//PdfWriter.getInstance(document, new FileOutputStream("sample1.pdf"));
		  PdfWriter.getInstance(document, response.getOutputStream());
		  document.open();
		  document.add(header);
		  document.add(new Paragraph(" "));
	      document.add(head1);
	      document.add(cpuT);
	      document.add(new Paragraph(" "));
	      document.add(head3);
	      document.add(monT);
	      document.add(new Paragraph(" "));
	      document.add(head2);
	      document.add(lapT);
	      document.add(new Paragraph(" "));
	      document.add(head5);
	      document.add(priT);
	      document.add(new Paragraph(" "));
	      document.add(head4);
	      document.add(ScanT);
	      document.add(new Paragraph(" "));
	      document.add(head7);
	      document.add(ACS);
	      document.add(new Paragraph(" "));
	      document.add(head6);
	      document.add(ServT);
		  document.close();
	} catch (DocumentException e) {
		
		e.printStackTrace();
	}
	  document.setPageSize(PageSize.A4);
	  System.out.println("Done");
	  response.setContentType("application/pdf");
	  
	  /*dispatcher=request.getRequestDispatcher("Inventoryproc.jsp");
	  dispatcher.forward(request,response);*/
	}

}
