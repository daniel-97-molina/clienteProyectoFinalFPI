package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.service.RestFulService;

@Controller
public class ApiController {

	@Autowired
	RestFulService rest;
	
	@GetMapping("/")
	public String get(ModelMap model,@CookieValue(value="empleado",required=false) String cookie) {
//model.addAttribute("lista",rest.getAllEmpleados());
		if(cookie==null) {
			return "index";
		}
		else {
		model.addAttribute("empleado",rest.getEmpleado(Integer.parseInt(cookie)));
		model.addAttribute("sucursales",rest.getSucursals());	
		model.addAttribute("miembros",rest.getMiembros(1));
		return "miembros";
		}
	}
}
