package com.pau.everis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
//	public Usuario updateUsuario(Long id, Usuario usuario) {
//		return null;
//	}
}
