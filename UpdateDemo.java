package com.quinnox.jdbc;
import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class UpdateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		int cnt=0;
		String sqlUpdate;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			sqlUpdate= "UPDATE employees SET last_name = ? WHERE employee_id= ?";
			pstmt = con.prepareStatement(sqlUpdate);
			
			Scanner s=new Scanner(System.in);
			System.out.println("Enter Employee Id:");
			int eid=s.nextInt();
			System.out.println("enter employee last name:");
			String lastname=s.next();
			
			pstmt.setString(1,lastname);
			pstmt.setInt(2,eid);
			int rowAffected = pstmt.executeUpdate();
			System.out.println(String.format("Row affected %d",rowAffected));
			
			lastname="Grohe";
			eid=101;
			pstmt.setString(1, lastname);
			pstmt.setInt(2,eid);
			
		 rowAffected = pstmt.executeUpdate();
			System.out.println(String.format("Row affected %d",rowAffected));
			con.close();
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
