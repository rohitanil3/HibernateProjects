package com.onesolvent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onesolvent.DAO.CustomerDAO;
import com.onesolvent.Entity.Customer;
import com.onesolvent.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/listcust")
	public String getCustomers(Model model){
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customersList", customers);
		return "customers";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model){
		Customer customer=new Customer();
		model.addAttribute("customer", customer);
		return "save_customers";
		
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer){
		customerService.saveCustomer(customer);
		
		return "redirect:listcust";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String editCustomer(@RequestParam("customerId") int id , Model model){
		
		Customer customer = customerService.getCustomerByID(id);
		model.addAttribute("custupdate", customer);
		
		return "update_customer";
	}

	@PostMapping("/update")
	public String updateCustomer(@ModelAttribute("custupdate") Customer customer){
		customerService.saveCustomer(customer);
		
		return "redirect:listcust";
		
	}

}
