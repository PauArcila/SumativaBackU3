package com.pau.everis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pau.everis.models.OrdenCompra;


@Repository
public interface OrdenRepository  extends JpaRepository<OrdenCompra, Long>{

}
