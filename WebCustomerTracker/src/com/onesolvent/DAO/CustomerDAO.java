package com.onesolvent.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onesolvent.Entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomerByID(int id);

}
