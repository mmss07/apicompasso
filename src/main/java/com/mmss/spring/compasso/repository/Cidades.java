package com.mmss.spring.compasso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmss.spring.compasso.model.Cidade;

public interface Cidades extends JpaRepository<Cidade, Integer > {

}
