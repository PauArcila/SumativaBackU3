package com.pau.everis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pau.everis.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
