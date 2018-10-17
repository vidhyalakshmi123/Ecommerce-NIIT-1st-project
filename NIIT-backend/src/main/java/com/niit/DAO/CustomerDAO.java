package com.niit.DAO;

import com.niit.model.Customer;

public interface CustomerDAO {
	public void registerCustomer(Customer customer);
	public boolean isEmailUnique(String email);
}