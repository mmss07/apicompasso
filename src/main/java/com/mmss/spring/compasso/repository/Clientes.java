package com.mmss.spring.compasso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmss.spring.compasso.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer > {
   
}
