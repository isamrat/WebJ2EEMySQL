package com.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	public static Connection getConnection() throws SQLException {
		String host = "localhost";
		String username =  "root"; 
		String password = "";
		Connection con = null;
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdb","root","");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
		
	}
	public static void closeConnection(Connection con) {
		if(con!=null) {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
