package com.pau.everis.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pau.everis.models.Usuario;
import com.pau.everis.services.ProductoService;
import com.pau.everis.services.UsuarioService;

@Controller
public class HomeController {

	@Autowired
	ProductoService prodService;
	
	@Autowired 
	UsuarioService usuarioService;
	
	
	@RequestMapping("/")
	public String index(HttpSession session, Model modelo) {
		modelo.addAttribute("listaProductos", prodService.getAll());
		//session.invalidate();
		session.setAttribute("registrado", 0);
		return "index.jsp";
	}
	
//	public String index(Model modelo) {
//		modelo.addAttribute("listaProductos", prodService.getAll());
//		//modelo.addAllAttributes(prodService.getAll());
//		return "index.jsp";
//	}
	
	@RequestMapping("/registro")
	public String registro(@ModelAttribute("usuario") Usuario usuario,
							Model model) {
		model.addAttribute("usuario", new Usuario());
		//usuarioService.addUsuario(usuario);
		return "registroUsuarios.jsp";
	}

}
