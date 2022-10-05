package com.logistica.proyecto.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeControl {

	@RequestMapping({"/"})
	public String inicio() {
		 
	   
		return "/home/login" ;
	}
	
}
