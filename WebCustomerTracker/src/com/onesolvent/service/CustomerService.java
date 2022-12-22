package com.onesolvent.service;

import java.util.List;

import com.onesolvent.Entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomerByID(int id);
}
