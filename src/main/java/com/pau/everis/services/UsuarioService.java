package com.pau.everis.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pau.everis.models.Rol;
import com.pau.everis.models.Usuario;
import com.pau.everis.repositories.RolRepository;
import com.pau.everis.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	RolRepository rolRepository;
	
	public Usuario saveAdmin(Usuario usuario) {
		 String hashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		 usuario.setPassword(hashed);
		 usuario.setRoles(rolRepository.findByNombre("ADMIN"));
		return usuarioRepository.save(usuario);
	}
	
	public Usuario saveUser(Usuario usuario) {
		 String hashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		 usuario.setPassword(hashed);
		 usuario.setRoles(rolRepository.findByNombre("USER"));
		return usuarioRepository.save(usuario);
	}
	
	public Usuario addUsuario(Usuario usuario) {
		Long cantidad= usuarioRepository.count();
		if (cantidad > 0) {
			this.saveUser(usuario);
		}
		else {
			this.saveAdmin(usuario);
		}
		System.out.println(cantidad);
		return usuario;
	}
	
	public List<Usuario> getAllUsuarios(){
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> findById(Long id){
		Optional<Usuario> objProd = usuarioRepository.findById(id);
		return objProd;		
	}
	
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public void deleteUsuario(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
	public boolean autenticacion(String email, String password) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		
		if (usuario == null) {// existencia de la persona
			return false;
		} else {
			if (BCrypt.checkpw(password, usuario.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	
//	public void poblarUsuarios() {
//		//poblar usuarios para iniciar sesión
//		Usuario usuarioAdmin = new Usuario( "yagami", "lighto", "yagami@mail.com", "1234");
//		List<Rol> roladmin=new ArrayList<Rol>();
//		Rol rol = new Rol(); rol.setNombre("ADMIN");
//		roladmin.add(rol);		
//		usuarioAdmin.setRoles(roladmin);
//		addUsuario(usuarioAdmin);
//		
//		Usuario usuarioUser = new Usuario( "kallfu", "chan", "kallfu@mail.com", "1234");
//		
//		List<Rol> roluser=new ArrayList<Rol>();
//		Rol rol2 = new Rol(); rol2.setNombre("USER");
//		roluser.add(rol2);		
//		usuarioUser.setRoles(roluser);
//		addUsuario(usuarioUser);
//		addUsuario(usuarioUser);
//	}
	
	
}
