package com.configration;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class dbConnection {

	private static final String userName="tedi";
	private static final String password="tedi";
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:MKYONG";
	private static final DateFormat dateFormat = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");
	
	public static String sqlDriver(String dbName, String userName, String password) throws ClassNotFoundException {
		// Load the SQLServerDriver class, build the 
	      // connection string, and get a connection 
	      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
	      String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;" + 
	                                        "database="+dbName+";" + 
	                                        "user="+userName+";" + 
	                                        "password="+password;
		return connectionUrl;
	}
	
	public static Connection setupGooPileConnection(String dbName, String userName, String password){  
	   Connection con = null;
	   try{ 
		   
	      String connectionUrl = sqlDriver( dbName,  userName,  password); 
	      con = DriverManager.getConnection(connectionUrl); 
	      System.out.println("Connected with GooPile Datasource."); 
	      
	      // Create and execute an SQL statement that returns some data.  
	      String SQL = "SELECT ID, name FROM Goo";  
	      Statement stmt = con.createStatement();  
	      ResultSet rs = stmt.executeQuery(SQL);
	      // Iterate through the data in the result set and display it.  
	      while (rs.next()){  
	           System.out.println(rs.getString(1) + " " + rs.getString(2));  
	           }
	   }catch(Exception e){ 
	    System.out.println(e.getMessage()); 
	    System.exit(0);  
	   } 
	   return con;
	}
	
	public static Connection setupWidgetPileConnection(String dbName, String userName, String password){
		Connection con=null;
	           try  
	           { 
	                // Load the SQLServerDriver class, build the 
	                // connection string, and get a connection 
	        	    String connectionUrl = sqlDriver( dbName,  userName,  password); 
	                con = DriverManager.getConnection(connectionUrl); 
	                System.out.println("Connected."); 

	                // Create and execute an SQL statement that returns some data.  
	                String SQL = "SELECT ID, name FROM Widget";  
	                Statement stmt = con.createStatement();  
	                ResultSet rs = stmt.executeQuery(SQL);

	                // Iterate through the data in the result set and display it.  
	                while (rs.next())  
	                {  
	                   System.out.println(rs.getString(1) + " " + rs.getString(2));  
	                }
	           }  
	           catch(Exception e)  
	           { 
	                System.out.println(e.getMessage()); 
	                System.exit(0);  
	           }
	           return con;
	}
	public static Connection setupGadgetPileConnection(String dbName, String userName, String password){
		Connection con = null;
	           try  
	           { 
	                // Load the SQLServerDriver class, build the 
	                // connection string, and get a connection 
	        	    String connectionUrl = sqlDriver( dbName,  userName,  password); 
	                con = DriverManager.getConnection(connectionUrl); 
	                System.out.println("Connected."); 

	                // Create and execute an SQL statement that returns some data.  
	                String SQL = "SELECT ID, name FROM Gadget";  
	                Statement stmt = con.createStatement();  
	                ResultSet rs = stmt.executeQuery(SQL);

	                // Iterate through the data in the result set and display it.  
	                while (rs.next())  
	                {  
	                   System.out.println(rs.getString(1) + " " + rs.getString(2));  
	                }
	           }  
	           catch(Exception e)  
	           { 
	                System.out.println(e.getMessage()); 
	                System.exit(0);  
	           } 
	           return con;
	}
}