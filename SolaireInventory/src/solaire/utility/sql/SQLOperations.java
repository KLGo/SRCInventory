package solaire.utility.sql;

import java.sql.*;

import javax.sql.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import solaire.model.SolaireBean;
import solaire.utility.sql.SQLCommands;

public class SQLOperations implements SQLCommands {

	private static Connection connection;
	
	private SQLOperations() {
	}
	
	private static Connection getDBConnection() {
		try {
		    InitialContext context = new InitialContext();
		    DataSource dataSource = (DataSource) 
		     context.lookup("java:comp/env/jdbc/Solaire");
		    
		    if (dataSource != null) {
		    	connection = dataSource.getConnection();
		    }
		} catch (NamingException e) {
		    e.printStackTrace();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return connection;
	 }
	
	public static Connection getConnection() {
		return (connection!=null)?connection:getDBConnection();
	}
	
	public static boolean addEmployee(SolaireBean employee, 
		Connection connection) {
		
		try {
	        PreparedStatement pstmt = connection.prepareStatement(INSERT_EMPLOYEE);
	        pstmt.setString(1, employee.getLastName()); 
	        pstmt.setString(2, employee.getFirstName());
	        pstmt.setString(3, employee.getPosition());
	        pstmt.setString(4, employee.getDepartment());            
	        pstmt.executeUpdate(); // execute insert statement  
		} catch (SQLException sqle) {
			System.out.println("SQLException - addEmployee: " + sqle.getMessage());
			return false; 
		}	
		return true;
	}
	public static boolean addCPU(SolaireBean CPU, 
			Connection connection) {
			
			try {
		        PreparedStatement pstmt = connection.prepareStatement(INSERT_CPU);
		        pstmt.setString(1, CPU.getDesc()); 
		        pstmt.setInt(2, CPU.getStock());
		        pstmt.setInt(3, 0);
		        pstmt.setInt(4, 0);
		        pstmt.setInt(5, CPU.getStock());
		        pstmt.executeUpdate(); // execute insert statement  
			} catch (SQLException sqle) {
				System.out.println("SQLException - addCPU: " + sqle.getMessage());
				return false; 
			}	
			return true;
		}
	public static boolean addLap(SolaireBean Laptop, 
			Connection connection) {
			
			try {
		        PreparedStatement pstmt = connection.prepareStatement(INSERT_Laptop);
		        pstmt.setString(1, Laptop.getDesc()); 
		        pstmt.setInt(2, Laptop.getStock());
		        pstmt.setInt(3, 0);
		        pstmt.setInt(4, 0);
		        pstmt.setInt(5, Laptop.getStock());
		        pstmt.executeUpdate(); // execute insert statement  
			} catch (SQLException sqle) {
				System.out.println("SQLException - addLaptop: " + sqle.getMessage());
				return false; 
			}	
			return true;
		}
	public static boolean addMon(SolaireBean Monitor, 
			Connection connection) {
			
			try {
		        PreparedStatement pstmt = connection.prepareStatement(INSERT_Monitor);
		        pstmt.setString(1, Monitor.getDesc()); 
		        pstmt.setInt(2, Monitor.getStock());
		        pstmt.setInt(3, 0);
		        pstmt.setInt(4, 0);
		        pstmt.setInt(5, Monitor.getStock());
		        pstmt.executeUpdate(); // execute insert statement  
			} catch (SQLException sqle) {
				System.out.println("SQLException - addMonitor: " + sqle.getMessage());
				return false; 
			}	
			return true;
		}
	public static boolean addScan(SolaireBean Scanner, 
			Connection connection) {
			
			try {
		        PreparedStatement pstmt = connection.prepareStatement(INSERT_Scan);
		        pstmt.setString(1, Scanner.getDesc()); 
		        pstmt.setInt(2, Scanner.getStock());
		        pstmt.setInt(3, 0);
		        pstmt.setInt(4, 0);
		        pstmt.setInt(5, Scanner.getStock());
		        pstmt.executeUpdate(); // execute insert statement  
			} catch (SQLException sqle) {
				System.out.println("SQLException - addScanner: " + sqle.getMessage());
				return false; 
			}	
			return true;
		}
	public static boolean addPrint(SolaireBean Printer, 
			Connection connection) {
			
			try {
		        PreparedStatement pstmt = connection.prepareStatement(INSERT_Printer);
		        pstmt.setString(1, Printer.getDesc()); 
		        pstmt.setInt(2, Printer.getStock());
		        pstmt.setInt(3, 0);
		        pstmt.setInt(4, 0);
		        pstmt.setInt(5, Printer.getStock());
		        pstmt.executeUpdate(); // execute insert statement  
			} catch (SQLException sqle) {
				System.out.println("SQLException - addPrinter: " + sqle.getMessage());
				return false; 
			}	
			return true;
		}
	public static boolean addAcs(SolaireBean Accessories, 
			Connection connection) {
			
			try {
		        PreparedStatement pstmt = connection.prepareStatement(INSERT_Accessories);
		        pstmt.setString(1, Accessories.getDesc()); 
		        pstmt.setInt(2, Accessories.getStock());
		        pstmt.setInt(3, 0);
		        pstmt.setInt(4, 0);
		        pstmt.setInt(5, Accessories.getStock());
		        pstmt.executeUpdate(); // execute insert statement  
			} catch (SQLException sqle) {
				System.out.println("SQLException - addAccessories: " + sqle.getMessage());
				return false; 
			}	
			return true;
		}
	public static boolean addName(SolaireBean Names,String Type, 
			Connection connection) {
			
			try {
		        PreparedStatement pstmt = connection.prepareStatement(INSERTNames);
		        pstmt.setString(1, Names.getDesc()); 
		        pstmt.setString(2, Type);
		        pstmt.setInt(3, Names.getId());
		        
		        pstmt.executeUpdate(); // execute insert statement  
			} catch (SQLException sqle) {
				System.out.println("SQLException - addAccessories: " + sqle.getMessage());
				return false; 
			}	
			return true;
		}
	
	public static boolean addSU(SolaireBean ServiceUnit, 
			Connection connection) {
			
			try {
		        PreparedStatement pstmt = connection.prepareStatement(INSERT_Service);
		        pstmt.setString(1, ServiceUnit.getDesc()); 
		        pstmt.setInt(2, ServiceUnit.getStock());
		        pstmt.setInt(3, 0);
		        pstmt.setInt(4, 0);
		        pstmt.setInt(5, ServiceUnit.getStock());
		        pstmt.executeUpdate(); // execute insert statement  
			} catch (SQLException sqle) {
				System.out.println("SQLException - addAccessories: " + sqle.getMessage());
				return false; 
			}	
			return true;
		}
	public static boolean addPull(String D,String T, String I, String S, int C, String L,
			Connection connection) {
			
			try {
				connection.setAutoCommit(true);
		        PreparedStatement pstmt = connection.prepareStatement(INSERT_PULL);
		        pstmt.setString(1, D); 
		        pstmt.setString(2, T);
		        pstmt.setString(3, I);
		        pstmt.setString(4, S);
		        pstmt.setInt(5,C);
		        pstmt.setString(6, L);
		        pstmt.executeUpdate(); // execute insert statement  
			} catch (SQLException sqle) {
				System.out.println("SQLException - addPull: " + sqle.getMessage());
				return false; 
			}	
			return true;
		}
	public static boolean addPut(String D,String T, String I, String S, String Comp, int C, String R,
			Connection connection) {
			
			try {
				connection.setAutoCommit(true);
		        PreparedStatement pstmt = connection.prepareStatement(INSERT_PUT);
		        pstmt.setString(1, D); 
		        pstmt.setString(2, T);
		        pstmt.setString(3, I);
		        pstmt.setString(4, S);
		        pstmt.setString(5, Comp);
		        pstmt.setInt(6,C);
		        pstmt.setString(7, R);
		        pstmt.executeUpdate(); // execute insert statement  
			} catch (SQLException sqle) {
				System.out.println("SQLException - addPut: " + sqle.getMessage());
				return false; 
			}	
			return true;
		}
	public static boolean searchAdmin(SolaireBean n, Connection connection){
		boolean Det= false;
		String uname=n.getUsername();
		String pass=n.getPassword();
		try {
	        PreparedStatement pstmt = 
	        	connection.prepareStatement(SEARCH_ADMIN);
	        pstmt.setString(1, uname);
	        pstmt.setString(2, pass);
	        ResultSet rs  = pstmt.executeQuery();
	        if(rs.next()){
	        	Det =true;
	        	return Det;
	        }else{
	        	return Det;
	        }
		}catch(SQLException sqle){
			return Det;
		}
	}
	
	public static SolaireBean searchEmployee(int id, 
		Connection connection) {
		
		SolaireBean employee = new SolaireBean();
		 
		try {
	        PreparedStatement pstmt = 
	        	connection.prepareStatement(SEARCH_EMPLOYEE);
	        pstmt.setInt(1, id);             
	        ResultSet rs  = pstmt.executeQuery();
	        
	        while (rs.next()) { 
	        	employee.setLastName(rs.getString("lastname"));
	        	employee.setFirstName(rs.getString("firstname"));
	        	employee.setPosition(rs.getString("position"));
	        	employee.setDepartment(rs.getString("department"));
	        }
		} catch (SQLException sqle) {
			System.out.println("SQLException - searchEmployee: " 
					+ sqle.getMessage());
			return employee; 
		}	
		return employee;
	}
	public static SolaireBean searchCPU(String T, 
			Connection connection) {
			
			SolaireBean CPU = new SolaireBean();
			 
			try {
		        PreparedStatement pstmt = 
		        	connection.prepareStatement(SEARCHCPU);
		        pstmt.setString(1, T);             
		        ResultSet rs  = pstmt.executeQuery();
		        
		        while (rs.next()) { 
		        	CPU.setId(rs.getInt("ID"));
		        	CPU.setDescrip(rs.getString("Description"));
		        	CPU.setStock(rs.getInt("Stocks"));
		        	CPU.setPullOut(rs.getInt("PullOut"));
		        	CPU.setRet(rs.getInt("NumReturn"));
		        	CPU.setRemain(rs.getInt("RemainingItems"));
		        	
		        }
			} catch (SQLException sqle) {
				System.out.println("SQLException - searchLaptop: " 
						+ sqle.getMessage());
				return CPU; 
			}	
			return CPU;
		}
	public static SolaireBean searchLap(String T, 
			Connection connection) {
			
			SolaireBean Laptop = new SolaireBean();
			 
			try {
		        PreparedStatement pstmt = 
		        	connection.prepareStatement(SEARCHLap);
		        pstmt.setString(1, T);             
		        ResultSet rs  = pstmt.executeQuery();
		        
		        while (rs.next()) { 
		        	Laptop.setId(rs.getInt("ID"));
		        	Laptop.setDescrip(rs.getString("Description"));
		        	Laptop.setStock(rs.getInt("Stocks"));
		        	Laptop.setPullOut(rs.getInt("PullOut"));
		        	Laptop.setRet(rs.getInt("NumReturn"));
		        	Laptop.setRemain(rs.getInt("RemainingItems"));
		        	
		        }
			} catch (SQLException sqle) {
				System.out.println("SQLException - searchLaptop: " 
						+ sqle.getMessage());
				return Laptop; 
			}	
			return Laptop;
		}
	public static SolaireBean searchMonitor(String T, 
			Connection connection) {
			
			SolaireBean Monitor = new SolaireBean();
			 
			try {
		        PreparedStatement pstmt = 
		        	connection.prepareStatement(SEARCHMoni);
		        pstmt.setString(1, T);             
		        ResultSet rs  = pstmt.executeQuery();
		        
		        while (rs.next()) { 
		        	Monitor.setId(rs.getInt("ID"));
		        	Monitor.setDescrip(rs.getString("Description"));
		        	Monitor.setStock(rs.getInt("Stocks"));
		        	Monitor.setPullOut(rs.getInt("PullOut"));
		        	Monitor.setRet(rs.getInt("NumReturn"));
		        	Monitor.setRemain(rs.getInt("RemainingItems"));
		        	
		        }
			} catch (SQLException sqle) {
				System.out.println("SQLException - searchEmployee: " 
						+ sqle.getMessage());
				return Monitor; 
			}	
			return Monitor;
		}
	public static SolaireBean searchScan(String T, 
			Connection connection) {
			
			SolaireBean Scanner = new SolaireBean();
			 
			try {
		        PreparedStatement pstmt = 
		        	connection.prepareStatement(SEARCHScan);
		        pstmt.setString(1, T);             
		        ResultSet rs  = pstmt.executeQuery();
		        
		        while (rs.next()) { 
		        	Scanner.setId(rs.getInt("ID"));
		        	Scanner.setDescrip(rs.getString("Description"));
		        	Scanner.setStock(rs.getInt("Stocks"));
		        	Scanner.setPullOut(rs.getInt("PullOut"));
		        	Scanner.setRet(rs.getInt("NumReturn"));
		        	Scanner.setRemain(rs.getInt("RemainingItems"));
		        	
		        }
			} catch (SQLException sqle) {
				System.out.println("SQLException - searchEmployee: " 
						+ sqle.getMessage());
				return Scanner; 
			}	
			return Scanner;
		}
	public static SolaireBean searchPrint(String T, 
			Connection connection) {
			
			SolaireBean Printer = new SolaireBean();
			 
			try {
		        PreparedStatement pstmt = 
		        	connection.prepareStatement(SEARCHPri);
		        pstmt.setString(1, T);             
		        ResultSet rs  = pstmt.executeQuery();
		        
		        while (rs.next()) { 
		        	Printer.setId(rs.getInt("ID"));
		        	Printer.setDescrip(rs.getString("Description"));
		        	Printer.setStock(rs.getInt("Stocks"));
		        	Printer.setPullOut(rs.getInt("PullOut"));
		        	Printer.setRet(rs.getInt("NumReturn"));
		        	Printer.setRemain(rs.getInt("RemainingItems"));
		        	
		        }
			} catch (SQLException sqle) {
				System.out.println("SQLException - searchEmployee: " 
						+ sqle.getMessage());
				return Printer; 
			}	
			return Printer;
		}
	public static SolaireBean searchAcs(String T, 
			Connection connection) {
			
			SolaireBean Acs = new SolaireBean();
			 
			try {
		        PreparedStatement pstmt = 
		        	connection.prepareStatement(SEARCHAcc);
		        pstmt.setString(1, T);             
		        ResultSet rs  = pstmt.executeQuery();
		        
		        while (rs.next()) { 
		        	Acs.setId(rs.getInt("ID"));
		        	Acs.setDescrip(rs.getString("Description"));
		        	Acs.setStock(rs.getInt("Stocks"));
		        	Acs.setPullOut(rs.getInt("PullOut"));
		        	Acs.setRet(rs.getInt("NumReturn"));
		        	Acs.setRemain(rs.getInt("RemainingItems"));
		        	
		        }
			} catch (SQLException sqle) {
				System.out.println("SQLException - searchEmployee: " 
						+ sqle.getMessage());
				return Acs; 
			}	
			return Acs;
		}
	public static SolaireBean searchSU(String T, 
			Connection connection) {
			
			SolaireBean Service = new SolaireBean();
			 
			try {
		        PreparedStatement pstmt = 
		        	connection.prepareStatement(SEARCHServ);
		        pstmt.setString(1, T);             
		        ResultSet rs  = pstmt.executeQuery();
		        
		        while (rs.next()) { 
		        	Service.setId(rs.getInt("ID"));
		        	Service.setDescrip(rs.getString("Description"));
		        	Service.setStock(rs.getInt("Stocks"));
		        	Service.setPullOut(rs.getInt("PullOut"));
		        	Service.setRet(rs.getInt("NumReturn"));
		        	Service.setRemain(rs.getInt("RemainingItems"));
		        	
		        }
			} catch (SQLException sqle) {
				System.out.println("SQLException - searchEmployee: " 
						+ sqle.getMessage());
				return Service; 
			}	
			return Service;
		}
	public static ResultSet getAllCPU(Connection connection) {
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(GETCPU);  
		} catch (SQLException sqle) {
			System.out.println("SQLException - getALLEmployees: " 
			  + sqle.getMessage());
			return rs; 
		}	
		return rs;
	}
	public static ResultSet getAllLaptop(Connection connection) {
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(GETLaptop);  
		} catch (SQLException sqle) {
			System.out.println("SQLException - getAllLap: " 
			  + sqle.getMessage());
			return rs; 
		}	
		return rs;
	}
	public static ResultSet getAllNames(Connection connection) {
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(GETNames);  
		} catch (SQLException sqle) {
			System.out.println("SQLException - getALLNames: " 
			  + sqle.getMessage());
			return rs; 
		}	
		return rs;
	}
	public static ResultSet getAllPullOut(Connection connection) {
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(GETPullOut);  
		} catch (SQLException sqle) {
			System.out.println("SQLException - getALLNames: " 
			  + sqle.getMessage());
			return rs; 
		}	
		return rs;
	}
	public static ResultSet getAllPutIn(Connection connection) {
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(GETPutIn);  
		} catch (SQLException sqle) {
			System.out.println("SQLException - getALLNames: " 
			  + sqle.getMessage());
			return rs; 
		}	
		return rs;
	}
	public static ResultSet getAllMonitor(Connection connection) {
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(GETMonitor);  
		} catch (SQLException sqle) {
			System.out.println("SQLException - getALLEmployees: " 
			  + sqle.getMessage());
			return rs; 
		}	
		return rs;
	}
	public static ResultSet getAllService(Connection connection) {
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(GETService);  
		} catch (SQLException sqle) {
			System.out.println("SQLException - getALLEmployees: " 
			  + sqle.getMessage());
			return rs; 
		}	
		return rs;
	}
	public static ResultSet getAllAccessories(Connection connection) {
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(GETAccessories);  
		} catch (SQLException sqle) {
			System.out.println("SQLException - getALLEmployees: " 
			  + sqle.getMessage());
			return rs; 
		}	
		return rs;
	}
	public static ResultSet getAllScan(Connection connection) {
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(GETScan);  
		} catch (SQLException sqle) {
			System.out.println("SQLException - getALLEmployees: " 
			  + sqle.getMessage());
			return rs; 
		}	
		return rs;
	}
	public static ResultSet getAllPrinter(Connection connection) {
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(GETPrinter);  
		} catch (SQLException sqle) {
			System.out.println("SQLException - getALLEmployees: " 
			  + sqle.getMessage());
			return rs; 
		}	
		return rs;
	}
	
	public static SolaireBean PULLCPU(int id,int Pull, 
			 Connection connection) {
			SolaireBean updated = new SolaireBean();
			int remaining=0, pull;
			 
			        
			     
			try {
				PreparedStatement pstmt = 
			        	connection.prepareStatement(SPCPU);
			        pstmt.setInt(1, id);             
			        ResultSet rs = pstmt.executeQuery();
			        while(rs.next()){
			        	updated.setId(rs.getInt("ID"));
			        	updated.setDescrip(rs.getString("Description"));
			        	updated.setStock(rs.getInt("Stocks"));
			        	updated.setPullOut(rs.getInt("PullOut"));
			        	updated.setRet(rs.getInt("NumReturn"));
			        	updated.setRemain(rs.getInt("RemainingItems"));
			        }
			        pull=updated.getPull()+Pull;
			        remaining=updated.getRemain()-Pull;
			        if(updated.getStock()<pull+updated.getRet()){
			        	updated.setError("The number of PC you are trying to pull out is more than the number of"			);
			        }else{
				connection.setAutoCommit(false);
		        pstmt = 
		        	connection.prepareStatement(PULLCPU);
		        pstmt.setInt(1, pull); 
		        pstmt.setInt(2, remaining);
		        pstmt.setInt(3, id);
		        pstmt.executeUpdate();   
		        connection.commit();}
			} catch (SQLException sqle) {
				System.out.println("SQLException - updateEmployee: " 
					+ sqle.getMessage());
				
				try {
					connection.rollback();
				} catch (SQLException sql) {
					System.err.println("Error on Update Connection Rollback - " 
						+ sql.getMessage());
				}
				return updated; 
			}	
			return updated;
		}
	public static SolaireBean PULLLAP(int id,int Pull, 
			 Connection connection) {
			SolaireBean updated = new SolaireBean();
			int remaining=0, pull;
			 
			        
			     
			try {
				PreparedStatement pstmt = 
			        	connection.prepareStatement(SPLap);
			        pstmt.setInt(1, id);             
			        ResultSet rs = pstmt.executeQuery();
			        while(rs.next()){
			        	updated.setId(rs.getInt("ID"));
			        	updated.setDescrip(rs.getString("Description"));
			        	updated.setStock(rs.getInt("Stocks"));
			        	updated.setPullOut(rs.getInt("PullOut"));
			        	updated.setRet(rs.getInt("NumReturn"));
			        	updated.setRemain(rs.getInt("RemainingItems"));
			        }
			        pull=updated.getPull()+Pull;
			        remaining=updated.getRemain()-Pull;
				connection.setAutoCommit(false);
		        pstmt = 
		        	connection.prepareStatement(PULLLap);
		        pstmt.setInt(1, pull); 
		        pstmt.setInt(2, remaining);
		        pstmt.setInt(3, id);
		        pstmt.executeUpdate();   
		        connection.commit();
			} catch (SQLException sqle) {
				System.out.println("SQLException - updateEmployee: " 
					+ sqle.getMessage());
				
				try {
					connection.rollback();
				} catch (SQLException sql) {
					System.err.println("Error on Update Connection Rollback - " 
						+ sql.getMessage());
				}
				return updated; 
			}	
			return updated;
		}
	public static SolaireBean PULLMon(int id,int Pull, 
			 Connection connection) {
			SolaireBean updated = new SolaireBean();
			int remaining=0, pull;
			 
			        
			     
			try {
				PreparedStatement pstmt = 
			        	connection.prepareStatement(SPMoni);
			        pstmt.setInt(1, id);             
			        ResultSet rs = pstmt.executeQuery();
			        while(rs.next()){
			        	updated.setId(rs.getInt("ID"));
			        	updated.setDescrip(rs.getString("Description"));
			        	updated.setStock(rs.getInt("Stocks"));
			        	updated.setPullOut(rs.getInt("PullOut"));
			        	updated.setRet(rs.getInt("NumReturn"));
			        	updated.setRemain(rs.getInt("RemainingItems"));
			        }
			        pull=updated.getPull()+Pull;
			        remaining=updated.getRemain()-Pull;
				connection.setAutoCommit(false);
		        pstmt = 
		        	connection.prepareStatement(PULLMoni);
		        pstmt.setInt(1, pull); 
		        pstmt.setInt(2, remaining);
		        pstmt.setInt(3, id);
		        pstmt.executeUpdate();   
		        connection.commit();
			} catch (SQLException sqle) {
				System.out.println("SQLException - updateEmployee: " 
					+ sqle.getMessage());
				
				try {
					connection.rollback();
				} catch (SQLException sql) {
					System.err.println("Error on Update Connection Rollback - " 
						+ sql.getMessage());
				}
				return updated; 
			}	
			return updated;
		}
	public static SolaireBean PULLPri(int id,int Pull, 
			 Connection connection) {
			SolaireBean updated = new SolaireBean();
			int remaining=0, pull;
			 
			        
			     
			try {
				PreparedStatement pstmt = 
			        	connection.prepareStatement(SPPri);
			        pstmt.setInt(1, id);             
			        ResultSet rs = pstmt.executeQuery();
			        while(rs.next()){
			        	updated.setId(rs.getInt("ID"));
			        	updated.setDescrip(rs.getString("Description"));
			        	updated.setStock(rs.getInt("Stocks"));
			        	updated.setPullOut(rs.getInt("PullOut"));
			        	updated.setRet(rs.getInt("NumReturn"));
			        	updated.setRemain(rs.getInt("RemainingItems"));
			        }
			        pull=updated.getPull()+Pull;
			        remaining=updated.getRemain()-Pull;
				connection.setAutoCommit(false);
		        pstmt = 
		        	connection.prepareStatement(PULLPrin);
		        pstmt.setInt(1, pull); 
		        pstmt.setInt(2, remaining);
		        pstmt.setInt(3, id);
		        pstmt.executeUpdate();   
		        connection.commit();
			} catch (SQLException sqle) {
				System.out.println("SQLException - updateEmployee: " 
					+ sqle.getMessage());
				
				try {
					connection.rollback();
				} catch (SQLException sql) {
					System.err.println("Error on Update Connection Rollback - " 
						+ sql.getMessage());
				}
				return updated; 
			}	
			return updated;
		}
	public static SolaireBean PULLSca(int id,int Pull, 
			 Connection connection) {
			SolaireBean updated = new SolaireBean();
			int remaining=0, pull;
			 
			        
			     
			try {
				PreparedStatement pstmt = 
			        	connection.prepareStatement(SPScan);
			        pstmt.setInt(1, id);             
			        ResultSet rs = pstmt.executeQuery();
			        while(rs.next()){
			        	updated.setId(rs.getInt("ID"));
			        	updated.setDescrip(rs.getString("Description"));
			        	updated.setStock(rs.getInt("Stocks"));
			        	updated.setPullOut(rs.getInt("PullOut"));
			        	updated.setRet(rs.getInt("NumReturn"));
			        	updated.setRemain(rs.getInt("RemainingItems"));
			        }
			        pull=updated.getPull()+Pull;
			        remaining=updated.getRemain()-Pull;
				connection.setAutoCommit(false);
		        pstmt = 
		        	connection.prepareStatement(PULLSca);
		        pstmt.setInt(1, pull); 
		        pstmt.setInt(2, remaining);
		        pstmt.setInt(3, id);
		        pstmt.executeUpdate();   
		        connection.commit();
			} catch (SQLException sqle) {
				System.out.println("SQLException - updateEmployee: " 
					+ sqle.getMessage());
				
				try {
					connection.rollback();
				} catch (SQLException sql) {
					System.err.println("Error on Update Connection Rollback - " 
						+ sql.getMessage());
				}
				return updated; 
			}	
			return updated;
		}
	public static SolaireBean PULLAcs(int id,int Pull, 
			 Connection connection) {
			SolaireBean updated = new SolaireBean();
			int remaining=0, pull;
			 
			        
			     
			try {
				PreparedStatement pstmt = 
			        	connection.prepareStatement(SPAcc);
			        pstmt.setInt(1, id);             
			        ResultSet rs = pstmt.executeQuery();
			        while(rs.next()){
			        	updated.setId(rs.getInt("ID"));
			        	updated.setDescrip(rs.getString("Description"));
			        	updated.setStock(rs.getInt("Stocks"));
			        	updated.setPullOut(rs.getInt("PullOut"));
			        	updated.setRet(rs.getInt("NumReturn"));
			        	updated.setRemain(rs.getInt("RemainingItems"));
			        }
			        pull=updated.getPull()+Pull;
			        remaining=updated.getRemain()-Pull;
				connection.setAutoCommit(false);
		        pstmt = 
		        	connection.prepareStatement(PULLAcs);
		        pstmt.setInt(1, pull); 
		        pstmt.setInt(2, remaining);
		        pstmt.setInt(3, id);
		        pstmt.executeUpdate();   
		        connection.commit();
			} catch (SQLException sqle) {
				System.out.println("SQLException - updateEmployee: " 
					+ sqle.getMessage());
				
				try {
					connection.rollback();
				} catch (SQLException sql) {
					System.err.println("Error on Update Connection Rollback - " 
						+ sql.getMessage());
				}
				return updated; 
			}	
			return updated;
		}
	public static SolaireBean PULLSU(int id,int Pull, 
			 Connection connection) {
			SolaireBean updated = new SolaireBean();
			int remaining=0, pull;
			 
			        
			     
			try {
				PreparedStatement pstmt = 
			        	connection.prepareStatement(SPServ);
			        pstmt.setInt(1, id);             
			        ResultSet rs = pstmt.executeQuery();
			        while(rs.next()){
			        	updated.setId(rs.getInt("ID"));
			        	updated.setDescrip(rs.getString("Description"));
			        	updated.setStock(rs.getInt("Stocks"));
			        	updated.setPullOut(rs.getInt("PullOut"));
			        	updated.setRet(rs.getInt("NumReturn"));
			        	updated.setRemain(rs.getInt("RemainingItems"));
			        }
			        pull=updated.getPull()+Pull;
			        remaining=updated.getRemain()-Pull;
				connection.setAutoCommit(false);
		        pstmt = 
		        	connection.prepareStatement(PULLSU);
		        pstmt.setInt(1, pull); 
		        pstmt.setInt(2, remaining);
		        pstmt.setInt(3, id);
		        pstmt.executeUpdate();   
		        connection.commit();
			} catch (SQLException sqle) {
				System.out.println("SQLException - updateService: " 
					+ sqle.getMessage());
				
				try {
					connection.rollback();
				} catch (SQLException sql) {
					System.err.println("Error on Update Connection Rollback - " 
						+ sql.getMessage());
				}
				return updated; 
			}	
			return updated;
		}
	public static SolaireBean PUTCPU(int id,int Put, 
			 Connection connection) {
			SolaireBean updated = new SolaireBean();
			int remaining=0, put;
			 
			        
			     
			try {
				PreparedStatement pstmt = 
			        	connection.prepareStatement(SPCPU);
			        pstmt.setInt(1, id);             
			        ResultSet rs = pstmt.executeQuery();
			        while(rs.next()){
			        	updated.setId(rs.getInt("ID"));
			        	updated.setDescrip(rs.getString("Description"));
			        	updated.setStock(rs.getInt("Stocks"));
			        	updated.setPullOut(rs.getInt("PullOut"));
			        	updated.setRet(rs.getInt("NumReturn"));
			        	updated.setRemain(rs.getInt("RemainingItems"));
			        }
			        put=updated.getRet()+Put;
			        remaining=updated.getRemain()+Put;
				connection.setAutoCommit(false);
		        pstmt = 
		        	connection.prepareStatement(PUTCPU);
		        pstmt.setInt(1, put); 
		        pstmt.setInt(2, remaining);
		        pstmt.setInt(3, id);
		        pstmt.executeUpdate();   
		        connection.commit();
			} catch (SQLException sqle) {
				System.out.println("SQLException - updateService: " 
					+ sqle.getMessage());
				
				try {
					connection.rollback();
				} catch (SQLException sql) {
					System.err.println("Error on Update Connection Rollback - " 
						+ sql.getMessage());
				}
				return updated; 
			}	
			return updated;
		}
	public static SolaireBean PUTMon(int id,int Put, 
			 Connection connection) {
			SolaireBean updated = new SolaireBean();
			int remaining=0, put;
			 
			        
			     
			try {
				PreparedStatement pstmt = 
			        	connection.prepareStatement(SPMoni);
			        pstmt.setInt(1, id);             
			        ResultSet rs = pstmt.executeQuery();
			        while(rs.next()){
			        	updated.setId(rs.getInt("ID"));
			        	updated.setDescrip(rs.getString("Description"));
			        	updated.setStock(rs.getInt("Stocks"));
			        	updated.setPullOut(rs.getInt("PullOut"));
			        	updated.setRet(rs.getInt("NumReturn"));
			        	updated.setRemain(rs.getInt("RemainingItems"));
			        }
			        put=updated.getRet()+Put;
			        remaining=updated.getRemain()+Put;
				connection.setAutoCommit(false);
		        pstmt = 
		        	connection.prepareStatement(PUTMoni);
		        pstmt.setInt(1, put); 
		        pstmt.setInt(2, remaining);
		        pstmt.setInt(3, id);
		        pstmt.executeUpdate();   
		        connection.commit();
			} catch (SQLException sqle) {
				System.out.println("SQLException - updateService: " 
					+ sqle.getMessage());
				
				try {
					connection.rollback();
				} catch (SQLException sql) {
					System.err.println("Error on Update Connection Rollback - " 
						+ sql.getMessage());
				}
				return updated; 
			}	
			return updated;
		}
	public static SolaireBean PUTLap(int id,int Put, 
			 Connection connection) {
			SolaireBean updated = new SolaireBean();
			int remaining=0, put;
			 
			        
			     
			try {
				PreparedStatement pstmt = 
			        	connection.prepareStatement(SPLap);
			        pstmt.setInt(1, id);             
			        ResultSet rs = pstmt.executeQuery();
			        while(rs.next()){
			        	updated.setId(rs.getInt("ID"));
			        	updated.setDescrip(rs.getString("Description"));
			        	updated.setStock(rs.getInt("Stocks"));
			        	updated.setPullOut(rs.getInt("PullOut"));
			        	updated.setRet(rs.getInt("NumReturn"));
			        	updated.setRemain(rs.getInt("RemainingItems"));
			        }
			        put=updated.getRet()+Put;
			        remaining=updated.getRemain()+Put;
				connection.setAutoCommit(false);
		        pstmt = 
		        	connection.prepareStatement(PUTLap);
		        pstmt.setInt(1, put); 
		        pstmt.setInt(2, remaining);
		        pstmt.setInt(3, id);
		        pstmt.executeUpdate();   
		        connection.commit();
			} catch (SQLException sqle) {
				System.out.println("SQLException - updateService: " 
					+ sqle.getMessage());
				
				try {
					connection.rollback();
				} catch (SQLException sql) {
					System.err.println("Error on Update Connection Rollback - " 
						+ sql.getMessage());
				}
				return updated; 
			}	
			return updated;
		}
	public static SolaireBean PUTPrin(int id,int Put, 
			 Connection connection) {
			SolaireBean updated = new SolaireBean();
			int remaining=0, put;
			 
			        
			     
			try {
				PreparedStatement pstmt = 
			        	connection.prepareStatement(SPPri);
			        pstmt.setInt(1, id);             
			        ResultSet rs = pstmt.executeQuery();
			        while(rs.next()){
			        	updated.setId(rs.getInt("ID"));
			        	updated.setDescrip(rs.getString("Description"));
			        	updated.setStock(rs.getInt("Stocks"));
			        	updated.setPullOut(rs.getInt("PullOut"));
			        	updated.setRet(rs.getInt("NumReturn"));
			        	updated.setRemain(rs.getInt("RemainingItems"));
			        }
			        put=updated.getRet()+Put;
			        remaining=updated.getRemain()+Put;
				connection.setAutoCommit(false);
		        pstmt = 
		        	connection.prepareStatement(PUTPrin);
		        pstmt.setInt(1, put); 
		        pstmt.setInt(2, remaining);
		        pstmt.setInt(3, id);
		        pstmt.executeUpdate();   
		        connection.commit();
			} catch (SQLException sqle) {
				System.out.println("SQLException - updateService: " 
					+ sqle.getMessage());
				
				try {
					connection.rollback();
				} catch (SQLException sql) {
					System.err.println("Error on Update Connection Rollback - " 
						+ sql.getMessage());
				}
				return updated; 
			}	
			return updated;
		}
	public static SolaireBean PUTSca(int id,int Put, 
			 Connection connection) {
			SolaireBean updated = new SolaireBean();
			int remaining=0, put;
			 
			        
			     
			try {
				PreparedStatement pstmt = 
			        	connection.prepareStatement(SPScan);
			        pstmt.setInt(1, id);             
			        ResultSet rs = pstmt.executeQuery();
			        while(rs.next()){
			        	updated.setId(rs.getInt("ID"));
			        	updated.setDescrip(rs.getString("Description"));
			        	updated.setStock(rs.getInt("Stocks"));
			        	updated.setPullOut(rs.getInt("PullOut"));
			        	updated.setRet(rs.getInt("NumReturn"));
			        	updated.setRemain(rs.getInt("RemainingItems"));
			        }
			        put=updated.getRet()+Put;
			        remaining=updated.getRemain()+Put;
				connection.setAutoCommit(false);
		        pstmt = 
		        	connection.prepareStatement(PUTSca);
		        pstmt.setInt(1, put); 
		        pstmt.setInt(2, remaining);
		        pstmt.setInt(3, id);
		        pstmt.executeUpdate();   
		        connection.commit();
			} catch (SQLException sqle) {
				System.out.println("SQLException - updateService: " 
					+ sqle.getMessage());
				
				try {
					connection.rollback();
				} catch (SQLException sql) {
					System.err.println("Error on Update Connection Rollback - " 
						+ sql.getMessage());
				}
				return updated; 
			}	
			return updated;
		}
	public static SolaireBean PUTAcs(int id,int Put, 
			 Connection connection) {
			SolaireBean updated = new SolaireBean();
			int remaining=0, put;
			 
			        
			     
			try {
				PreparedStatement pstmt = 
			        	connection.prepareStatement(SPAcc);
			        pstmt.setInt(1, id);             
			        ResultSet rs = pstmt.executeQuery();
			        while(rs.next()){
			        	updated.setId(rs.getInt("ID"));
			        	updated.setDescrip(rs.getString("Description"));
			        	updated.setStock(rs.getInt("Stocks"));
			        	updated.setPullOut(rs.getInt("PullOut"));
			        	updated.setRet(rs.getInt("NumReturn"));
			        	updated.setRemain(rs.getInt("RemainingItems"));
			        }
			        put=updated.getRet()+Put;
			        remaining=updated.getRemain()+Put;
				connection.setAutoCommit(false);
		        pstmt = 
		        	connection.prepareStatement(PUTAcs);
		        pstmt.setInt(1, put); 
		        pstmt.setInt(2, remaining);
		        pstmt.setInt(3, id);
		        pstmt.executeUpdate();   
		        connection.commit();
			} catch (SQLException sqle) {
				System.out.println("SQLException - updateService: " 
					+ sqle.getMessage());
				
				try {
					connection.rollback();
				} catch (SQLException sql) {
					System.err.println("Error on Update Connection Rollback - " 
						+ sql.getMessage());
				}
				return updated; 
			}	
			return updated;
		}
	public static SolaireBean PUTSU(int id,int Put, 
			 Connection connection) {
			SolaireBean updated = new SolaireBean();
			int remaining=0, put;
			 
			        
			     
			try {
				PreparedStatement pstmt = 
			        	connection.prepareStatement(SPServ);
			        pstmt.setInt(1, id);             
			        ResultSet rs = pstmt.executeQuery();
			        while(rs.next()){
			        	updated.setId(rs.getInt("ID"));
			        	updated.setDescrip(rs.getString("Description"));
			        	updated.setStock(rs.getInt("Stocks"));
			        	updated.setPullOut(rs.getInt("PullOut"));
			        	updated.setRet(rs.getInt("NumReturn"));
			        	updated.setRemain(rs.getInt("RemainingItems"));
			        }
			        put=updated.getRet()+Put;
			        remaining=updated.getRemain()+Put;
				connection.setAutoCommit(false);
		        pstmt = 
		        	connection.prepareStatement(PUTSU);
		        pstmt.setInt(1, put); 
		        pstmt.setInt(2, remaining);
		        pstmt.setInt(3, id);
		        pstmt.executeUpdate();   
		        connection.commit();
			} catch (SQLException sqle) {
				System.out.println("SQLException - updateService: " 
					+ sqle.getMessage());
				
				try {
					connection.rollback();
				} catch (SQLException sql) {
					System.err.println("Error on Update Connection Rollback - " 
						+ sql.getMessage());
				}
				return updated; 
			}	
			return updated;
		}
	
	
	
	
	public static int updateEmployee(SolaireBean employee, 
		int id, Connection connection) {
		int updated = 0;
		try {
			connection.setAutoCommit(false);
	        PreparedStatement pstmt = 
	        	connection.prepareStatement(UPDATE_EMPLOYEE);
	        pstmt.setString(1, employee.getLastName()); 
	        pstmt.setString(2, employee.getFirstName());
	        pstmt.setString(3, employee.getPosition());
	        pstmt.setString(4, employee.getDepartment()); 
	        pstmt.setInt(5, id); 
	        updated = pstmt.executeUpdate();   
	        connection.commit();
		} catch (SQLException sqle) {
			System.out.println("SQLException - updateEmployee: " 
				+ sqle.getMessage());
			
			try {
				connection.rollback();
			} catch (SQLException sql) {
				System.err.println("Error on Update Connection Rollback - " 
					+ sql.getMessage());
			}
			return updated; 
		}	
		return updated;
	}
	
	public static synchronized int deleteEmployee(int id, Connection connection) {
		int updated = 0;
		
		try {
			connection.setAutoCommit(false);
	        PreparedStatement pstmt = connection.prepareStatement(DELETE_EMPLOYEE);
	        pstmt.setInt(1, id);             
	        updated  = pstmt.executeUpdate();
	        connection.commit();
		} catch (SQLException sqle) {
			System.out.println("SQLException - deleteEmployee: " + sqle.getMessage());
			
			try {
				connection.rollback();
			} catch (SQLException sql) {
				System.err.println("Error on Delete Connection Rollback - " + sql.getMessage());
			}
			return updated; 
		}	
		return updated;
	}
}
