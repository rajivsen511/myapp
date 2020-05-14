package com.zensar.DBDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDao {
	
	public void getUser(Connection conn) throws SQLException {
		
		try {
			//Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establishing Connection to connect database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			
			//Execute Query SELECT id, name, age FROM emp
			Statement st = conn.createStatement();
			String sql = "SELECT * FROM EMPLOYEE";
			ResultSet rs = st.executeQuery(sql);
			
			//Retrive result from result set
			while(rs.next()) {
				
			//	String name = rs.getString("name");
			//	String username = rs.getString("username");
			//	String password = rs.getString("password");
			//	String address = rs.getString("address");
				
			//	int age = rs.getInt("age");
				
				//Display values:
			//	System.out.println("name" +name);
			//	System.out.println("username : "+username);
			//	System.out.println("password" +password);
			//	System.out.println("address: "+address);
			 //   System.out.println("age"+age);
				
			}
			
			rs.close();
			st.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
