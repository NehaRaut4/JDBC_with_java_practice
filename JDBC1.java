package com.app;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = null;
		CallableStatement cstmt;
		
		try {
			//Registering Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(" driver found");
			//Connection establishment
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","Username","**Password**");
			System.out.println("Connection established");
			
			//creating CallableStatement
			cstmt= con.prepareCall("{call procedure1()}");
			
			boolean status = cstmt.execute();
			if(status)
				System.out.println("Table created successfully !! ");
			else
				System.out.println("Table cannot be created !! ");
		     } catch(Exception e) {System.out.println(e);}
		
		
		con.close();
		
	}

	
	
}
