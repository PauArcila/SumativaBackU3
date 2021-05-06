package com.pau.everis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pau.everis.models.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
	List<Rol> findAll();
	List<Rol> findByNombre(String nombre);
}
