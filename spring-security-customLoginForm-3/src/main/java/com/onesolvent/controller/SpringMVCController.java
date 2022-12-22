package com.onesolvent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMVCController {
	
	@GetMapping("/")
	public String getpage(){
		
		return "main";
	}

}
