package com.app;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;


public class JDBC1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner s = new Scanner(System.in);
		Connection con = null;
	    CallableStatement cstmt;
	  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver found");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","user","password");
			System.out.println("Connection established");
			
			cstmt=con.prepareCall("{call procedure2(?,?,?)}");//procedure has 1 in and 2 out parameters
			
			System.out.println("Enter Employee id whose data to be fetched - ");
			int id = s.nextInt();
			
			cstmt.setInt(1, id);
			
				/*
				 * cstmt.registerOutParameter(2, Types.VARCHAR); cstmt.registerOutParameter(3,
				 * Types.FLOAT);
				 */
			cstmt.execute();
			
			System.out.println(cstmt.getString(2));
			System.out.println(cstmt.getFloat(3));
			
			System.out.println("success");
	  } catch(Exception e) {System.out.println(e);}
	
	con.close();
	

}
}
