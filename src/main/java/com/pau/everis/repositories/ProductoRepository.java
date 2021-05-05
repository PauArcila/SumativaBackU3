package com.pau.everis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pau.everis.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
