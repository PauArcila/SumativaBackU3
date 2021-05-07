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
	
	public void poblarCategorias() {
		//poblar categorías que se ven en el formulario
		Categoria cat1= new Categoria("Hogar");
		Categoria cat2= new Categoria("Ferretería");
		Categoria cat3= new Categoria("Electrónica");
		addCategoria(cat1);
		addCategoria(cat2);
		addCategoria(cat3);
	}

	
	
}