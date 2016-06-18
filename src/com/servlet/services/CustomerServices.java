package com.servlet.services;

import com.servlet.beans.Customer;
import com.servlet.dao.CustomerDAO;

public class CustomerServices {
	public int createCustomer(Customer c) throws Exception {
		CustomerDAO cdao = new CustomerDAO();
		return cdao.addCustomerDetails(c);
		
	}
}
