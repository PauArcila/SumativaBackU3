package com.pau.everis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pau.everis.services.ProductoService;

@Controller
public class HomeController {

	@Autowired
	ProductoService prodService;
	
	
	@RequestMapping("/")
	public String index(Model modelo) {
		modelo.addAttribute("listaProductos", prodService.getAll());
		//modelo.addAllAttributes(prodService.getAll());
		return "index.jsp";
	}

}
