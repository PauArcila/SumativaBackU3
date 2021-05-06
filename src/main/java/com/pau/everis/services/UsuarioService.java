package com.pau.everis.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pau.everis.models.Rol;
import com.pau.everis.models.Usuario;
import com.pau.everis.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario addUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> getAllUsuarios(){
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> findById(Long id){
		Optional<Usuario> objProd = usuarioRepository.findById(id);
		return objProd;		
	}
	
	public void deleteProd(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
	public void poblarUsuarios() {
		//poblar usuarios para iniciar sesión
		Usuario usuarioAdmin = new Usuario( "yagami", "lighto", "yagami@mail.com", "1234");
		List<Rol> roladmin=new ArrayList<Rol>();
		Rol rol = new Rol(); rol.setNombre("ADMIN");
		roladmin.add(rol);		
		usuarioAdmin.setRoles(roladmin);
		addUsuario(usuarioAdmin);
		
		Usuario usuarioUser = new Usuario( "kallfu", "chan", "kallfu@mail.com", "1234");
		
		List<Rol> roluser=new ArrayList<Rol>();
		Rol rol2 = new Rol(); rol2.setNombre("USER");
		roluser.add(rol2);		
		usuarioUser.setRoles(roluser);
		addUsuario(usuarioUser);
		addUsuario(usuarioUser);
	}
	
	
}
