package com.pau.everis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pau.everis.models.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

	Login findByEmail(String email);
}