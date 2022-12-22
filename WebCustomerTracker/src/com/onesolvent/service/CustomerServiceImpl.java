package com.onesolvent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onesolvent.DAO.CustomerDAO;
import com.onesolvent.Entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDAO customerDAO;

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(customer);
		
	}

	@Override
	public Customer getCustomerByID(int id) {
		// TODO Auto-generated method stub
		
		Customer customer = customerDAO.getCustomerByID(id);
		return customer;
		
	}

}
