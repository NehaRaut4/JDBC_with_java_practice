package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class JDBC1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner s = new Scanner(System.in);
		PreparedStatement stmt;
		Connection con = null;
		ResultSet rs;
		
		try {
		//registering driver for mysql
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver found");
		//Connection establishment
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","user","password");
		System.out.println("Connection established!!!");
		
		stmt = con.prepareStatement("insert into emp values(?,?,?)");
		System.out.println("Enter Employee id - ");
		int id = s.nextInt();
		System.out.println("Enter Employee Name - ");
		String name = s.next();
		System.out.println("Enter Employee Salary - ");
		float sal = s.nextFloat();
		
		//sending user entered values to insert statement to enter employee record in emp
		stmt.setInt(1, id);
		stmt.setString(2, name);
		stmt.setFloat(3, sal);
		
		int status = stmt.executeUpdate();
		if(status > 0)
			System.out.println("record inserted successfully!! ");
		else
			System.out.println("record Insertion failed !! ");
		
		
		
		rs = stmt.executeQuery("select * from emp");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getFloat(3));
		}

	        } catch(Exception e) { System.out.println(e);}
	}
	
	
}
