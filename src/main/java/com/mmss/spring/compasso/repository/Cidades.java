package com.mmss.spring.compasso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.mmss.spring.compasso.model.Cidade;

public interface Cidades extends JpaRepository<Cidade, Integer > {

}
