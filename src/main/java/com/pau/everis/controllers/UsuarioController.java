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
	
		if((usuario.getNombre().isEmpty() || usuario.getApellido().isEmpty() )
		||( usuario.getUsername().isEmpty() || usuario.getPassword().isEmpty())) {
			System.out.println("Uno o más datos nulos: " + usuario.getNombre());
			String mensaje = "Debe completar todos los campos";
			model.addAttribute("mensaje", mensaje);
		}
		else {
			userService.addUsuario(usuario);
			String mensaje = "Usuario registrado correctamente";
			model.addAttribute("mensaje", mensaje);
		}
		
		return "redirect:/";//"NewFile.jsp"
	}
	

}
