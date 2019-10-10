package com.quinnox.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args) {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String user = "hr";
		String password = "hr";
	
	
		try{
		Class.forName(driverName);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery("select * from employees");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		
	}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	}


