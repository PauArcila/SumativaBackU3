package com.pau.everis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pau.everis.models.Categoria;
import com.pau.everis.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public void addCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
		
	}
	
	public List<Categoria> getAll(){		
		return categoriaRepository.findAll();
	}
	
	public Categoria getById(Long id) {
		return categoriaRepository.findById(id).get();
	}
	
	
}