package com.pau.everis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pau.everis.models.Producto;
import com.pau.everis.repositories.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepository;
	
	public void addProducto(Producto producto) {
		productoRepository.save(producto);
	}
	
	public List<Producto> getAll(){
		return productoRepository.findAll();
	}
	
	public Producto getById(Long id) {
		return productoRepository.findById(id).get();
	}

}
