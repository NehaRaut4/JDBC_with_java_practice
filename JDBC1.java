package com.app;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
import com.mysql.cj.xdevapi.Type;

public class JDBC1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		

		Scanner s = new Scanner(System.in);
		Connection con = null;
		CallableStatement cstmt;
		
		try {
			//registering driver for mySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver found");
			//establishing connection 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","user","password");
			System.out.println("Connection established");
			//executing stored function to add two integers 
			//first ? is result and function(?,?) these are parameters for function 
			cstmt= con.prepareCall("{?=call function1(?,?)}");
			
			System.out.println("Enter Number 1 ");
			int num1 = s.nextInt();
			System.out.println("Enter Number 2 ");
			int num2 = s.nextInt();
			//passing parameters to function(?,?) -->> num1,num2
			cstmt.setInt(2, num1);
			cstmt.setInt(3, num2);
			//getting result of addition which stored in first '?' in prepareCall statement
			cstmt.registerOutParameter(1, Types.INTEGER);
			//executing prepareCall --->> execute() returns  true if statement returns ResultSet Object else false 
			boolean status = cstmt.execute();
	        System.out.println(status);//here return false because statement returns no ResultSetObject
			System.out.println("Addition="+cstmt.getInt(1));
		}catch(Exception e) {System.out.println(e);}
		
		
		con.close();
		
		
		
	}
}
