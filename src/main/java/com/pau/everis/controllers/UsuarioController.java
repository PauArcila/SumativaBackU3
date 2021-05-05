package com.pau.everis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pau.everis.models.Usuario;
import com.pau.everis.repositories.UsuarioRepository;
import com.pau.everis.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService userService;
	
	@Autowired
	UsuarioRepository userRepo;
	
	@RequestMapping("/muestraFormulario")
	public String muestraFormulario(Model model) {
		System.out.println("nombrecito" + model.getAttribute("usuario"));
		Usuario usuario=new Usuario();
		model.addAttribute("usuario", usuario);
		return "registroUsuarios.jsp";
	}
	
	@RequestMapping("/procesaFormulario")
	public String procesaFormulario(@ModelAttribute("usuario") Usuario usuario,
									Model model){
		Usuario user = new Usuario();//nombre, apellido, username, password);
		user.setNombre(usuario.getNombre());
		user.setApellido(usuario.getApellido());
		user.setUsername(usuario.getUsername());
		user.setPassword(usuario.getPassword());
		System.out.println("nombre desde el procesaFormulario: " + usuario.getNombre());
		userService.addUsuario(usuario);

		return "redirect:/";//"NewFile.jsp"
	}
	

}
