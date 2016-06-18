package com.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.servlet.beans.Customer;

public class CustomerDAO {
	private Connection connect = null;
	private PreparedStatement ps1 = null;
	private PreparedStatement ps2 = null;
	private ResultSet rs = null;
	
	public int addCustomerDetails(Customer c) throws Exception{
		int custId = 0;
		connect = DBConnection.getConnection();
		System.out.println("$$$$$$$$ Connection Established $$$$$$$$");
		String sql= "insert into tbl_customer values(?,?,?)";
		ps1 = connect.prepareStatement(sql);
		
		ps1.setInt(1, c.getCustId());
		ps1.setString(2, c.getName());
		ps1.setInt(3, c.getAge());
		ps1.executeUpdate();
		
		ps2 = connect.prepareStatement("select * from tbl_customer");
		rs = ps2.executeQuery();
		while(rs.next()) {
			custId = rs.getInt(1);
		}
		DBConnection.closeConnection(connect);
		return custId;
	}
}
